package com.metier;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.facture.metier.FactureMetier;
import com.facture.metier.IFactureMetier;
import com.facture.model.AutresProduits;
import com.facture.model.Livres;
import com.facture.model.MedicamentsAndAliments;
import com.facture.model.Produit;

public class FactureMetierTest extends TestCase {
	
	
	public static void main(String[] args) throws Exception {                    
	       JUnitCore.main(
	         "com.metier.FactureMetierTest");            
	}
	
	IFactureMetier facture = new FactureMetier();
    List<Produit> produits = new ArrayList<Produit>();
        
    final int FACTURE = 0;
    final int TAXE = 1;

	@Test
	public void testGetSommeTotalFactureAndTaxeFirstInput() {
		
		List<Double> factureAndTaxe = facture.getSommeTotalFactureAndTaxe(setListProduitAndTaxeFirstInput());
		assertEquals(factureAndTaxe.get(FACTURE), 48.05);
		assertEquals(factureAndTaxe.get(TAXE), 5.5);
	}
	
	@Test
	public void testGetSommeTotalFactureAndTaxeSecondeInput() {
		
		List<Double> factureAndTaxe = facture.getSommeTotalFactureAndTaxe(setListProduitAndTaxeSecondetInput());		
		assertEquals(factureAndTaxe.get(FACTURE), 199.15);
		assertEquals(factureAndTaxe.get(TAXE), 36,65);
	}
	
	@Test
	public void testGetSommeTotalFactureAndTaxethirdInput() {
				
		List<Double> factureAndTaxe = facture.getSommeTotalFactureAndTaxe(setListProduitThird());				
		assertEquals(factureAndTaxe.get(FACTURE) , 145.7);
		assertEquals(factureAndTaxe.get(TAXE) , 18.95);
	}
			
	@Test 
	public void testfactureDeuxBoitesChocoLocal(){
		
		double coutDeuxBoitesChocoImp = coutProduit(new MedicamentsAndAliments(10, false, 2));		
		assertEquals(coutDeuxBoitesChocoImp , 20.0);
	}
		
	@Test 
	public void  testfactureDeuxLivreLocal(){
		
		double coutLivresTTC = coutProduit(new Livres( 12.49, false , 2));
		assertEquals(coutLivresTTC , 27,5);//1
	}
	
	@Test 
	public void testfactureUnCdLocal(){
		
		double coutCDTTC = coutProduit(new AutresProduits(14.99, false, 1));		
		assertEquals(coutCDTTC , 18.0);//2
	}
	

	@Test 
	public void testfactureTroisBarreChocoLocal(){
		
		double coutChocolatTTC = coutProduit(new MedicamentsAndAliments(0.85, false, 3));		
		assertEquals(coutChocolatTTC , 2.55);//3
	}
	

	@Test 
	public void testfactureDeuxBoitesChocoImp(){
		
		double coutDeuxBoitesChocoImp = coutProduit(new MedicamentsAndAliments(10, true, 2));		
		assertEquals(coutDeuxBoitesChocoImp , 21.0);//4
	}
	
	@Test 
	public void factureTroisFlaconParfImpo(){
			
		double coutTroisFlaconParfImpoTTC = coutProduit(new AutresProduits(47.50, true, 3));		
		assertEquals(coutTroisFlaconParfImpoTTC , 178);
	}
	 
	@Test 
	public void  testfactureDeuxFlaconParfImpo(){
		
		double coutDeuxFlaconParfImpoTTC = coutProduit(new AutresProduits(27.99, true, 2));		
		assertEquals(coutDeuxFlaconParfImpoTTC , 70.0);
	}
	
	@Test 
	public void  testfactureUnFlaconParfLocal(){
		
		double coutUnFlaconParfLocalTTC = coutProduit(new AutresProduits(18.99, false, 1));		
		assertEquals(coutUnFlaconParfLocalTTC , 22.8);

	}
	
	@Test 
	public void  testfactureTroisBoiteContreMigraineLocal(){
		
		double coutTroisBoiteContreMigraineLocalTTC = coutProduit(new MedicamentsAndAliments(9.75, false, 3));		
		assertEquals(coutTroisBoiteContreMigraineLocalTTC , 29.25);
	}
	
	@Test 
	public void  testfactureDeuxBoiteChocolatImpo(){
		
		double coutDeuxBoiteChocolatImpoTTC = coutProduit(new MedicamentsAndAliments(11.25, true, 2));		
		assertEquals(coutDeuxBoiteChocolatImpoTTC , 23.65);
	}
	
	private double coutProduit(Produit produit) {
		double coutProduitTTC = facture.calculFactureParProduit(produit.getTaxe(), produit.getPrix() , produit.getQuantite(), produit.isImported());
		return coutProduitTTC;
	}

	private List<Produit>  setListProduitAndTaxeFirstInput() {
		List<Produit> produits = new ArrayList<Produit>();
		produits.add(new Livres(12.49, false ,2));
		produits.add(new AutresProduits(14.99, false, 1));
		produits.add(new MedicamentsAndAliments(0.85, false ,3));
		
		return produits ;
	}

	private List<Produit> setListProduitAndTaxeSecondetInput() {
			
	List<Produit> produits = new ArrayList<Produit>();
	produits.add(new MedicamentsAndAliments(10, true ,2));
	produits.add(new AutresProduits(47.50, true, 3));
	
	return produits ;
		
	}

	private List<Produit> setListProduitThird() {
		
		List<Produit> produits = new ArrayList<Produit>();
		produits.add(new MedicamentsAndAliments(9.75, false ,3));
		produits.add(new AutresProduits(18.99, false, 1));
		produits.add(new AutresProduits(27.99, true, 2));
		produits.add(new MedicamentsAndAliments(11.25, true ,2));
		
		return produits ;
	    
	}
}
