/*
package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;
    Produit produit = new Produit("p", "pc" , 12 ,new Date() );
    @Order(1)
    @Test
    void Add(){
        Produit produitAdded =  ps.addProduit(produit);
        Assertions.assertEquals(produitAdded.getCodeProduit(), produitAdded.getCodeProduit());
    }

    @Test
    @Order(2)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(1, listProduits.size());
    }
    

    @Order(3)
    @Test
    void Update(){
        log.info("Update Produit: "+ps.updateProduit(new Produit(2L,"produit1", "console" , 500 ,new Date() )).toString());
    }

    @Order(4)
    @Test
    void Delete() {
       ps.deleteProduit(2L);
    }

}
*/