package com.facture.model;


public class MedicamentsAndAliments extends Produit {
				
	final int TAXZEROPOURCENT = 0;
	
			
	public MedicamentsAndAliments(double prix , boolean isImported, int quantite){	
		
		super(prix ,isImported, quantite);
		this.taxe= TAXZEROPOURCENT ;
		
	}
}
