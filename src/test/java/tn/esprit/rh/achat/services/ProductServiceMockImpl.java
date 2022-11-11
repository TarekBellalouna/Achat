package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

	@SpringBootTest
	@ExtendWith(MockitoExtension.class)
	public class ProductServiceMockImpl {

	    @Mock
	    ProduitRepository produitRepository;

	    @InjectMocks
	    ProduitServiceImpl produitServiceImpl;

	    Produit produit = new Produit("produit1", "console" , 500 ,new Date() );

	    List<Produit> ProduitList = new ArrayList<Produit>() {
	        {
	            add(new Produit(2L,"produit2", "pc", 2500,  new Date()));
	            add(new Produit(3L,"produit3", "tv", 1000 , new Date()));
	        }
	    };

		@Order(1)
		@Test
		void testAddProduit() {
			Mockito.when(produitRepository.save(Mockito.any())).thenReturn(new Produit());
			produitServiceImpl.addProduit(ProduitList.get(0));
			produitServiceImpl.addProduit(ProduitList.get(1));
			Mockito.when(produitRepository.findById(Mockito.any())).thenReturn(Optional.of(ProduitList.get(0)));
			Assertions.assertNotNull(produitServiceImpl.retrieveProduit(2L).getIdProduit());
			Mockito.when(produitRepository.findById(Mockito.any())).thenReturn(Optional.of(ProduitList.get(1)));
			Assertions.assertNotNull(produitServiceImpl.retrieveProduit(3L).getIdProduit());
		}

		@Order(2)
		@Test
		void testModifyProduit() {
			ProduitList.forEach(produit ->{
				if(produit.getIdProduit()==2L){
					produit.setLibelleProduit("PC GAMER");
					produit.setPrix(3000);
				}
			});
			Mockito.when(produitRepository.save(Mockito.any())).thenReturn(new Produit());
			produitServiceImpl.updateProduit(ProduitList.get(0));
			Mockito.when(produitRepository.findById(Mockito.any())).thenReturn(Optional.of(ProduitList.get(0)));
			Assertions.assertNotNull(produitServiceImpl.retrieveProduit(2L).getIdProduit());
		}

		@Order(3)
		@Test
		void testRetrieveProduit() {
			Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
			Produit prd = produitServiceImpl.retrieveProduit(2L);
			Assertions.assertNotNull(prd);
		}

		@Order(4)
		@Test
		void testDeleteProduit() {
			produitServiceImpl.deleteProduit(2L);
			Assertions.assertNotNull(ProduitList);
		}
		

	
}

