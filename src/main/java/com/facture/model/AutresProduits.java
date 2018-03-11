package com.facture.model;


public class AutresProduits extends Produit{
	
	
	final int TAXEVINGHTPOURCENT = 20;	
	
	public AutresProduits (double prix , boolean isImported, int quantite ) {
		super( prix ,  isImported, quantite);
		this.taxe= TAXEVINGHTPOURCENT ;
	}
	 	
}