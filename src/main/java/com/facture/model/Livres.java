package com.facture.model;



public class Livres extends Produit{

	final int TAXEDIXPOURCENT = 10;
		
	public Livres (double prix , boolean isImported ,int quantite) {	
		super( prix ,  isImported, quantite);
		super.taxe= TAXEDIXPOURCENT ;
		
	}
	 	
}
