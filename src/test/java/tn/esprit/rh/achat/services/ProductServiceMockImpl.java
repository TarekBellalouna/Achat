package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductServiceMockImpl {

	@SpringBootTest
	@ExtendWith(MockitoExtension.class)
	public class ProductServiceImplMock {

	    @Mock
	    ProduitRepository produitRepository;

	    @InjectMocks
	    ProduitServiceImpl produitServiceImpl;

	    Produit produit = new Produit("produit1", "console" , 500 ,new Date() );

	    List<Produit> listUsers = new ArrayList<Produit>() {
	        {
	            add(new Produit("produit2", "pc", 2500,  new Date()));
	            add(new Produit("produit3", "tv", 1000 , new Date()));
	        }
	    };
	    @Test
	    public void testRetrieveProduit() {
	        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
	        Produit prod1 = produitServiceImpl.retrieveProduit(1L);
	        Assertions.assertNotNull(prod1);
	    }
	
}
	}
