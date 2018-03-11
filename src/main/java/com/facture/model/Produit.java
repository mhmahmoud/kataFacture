package com.facture.model;


public class Produit {
	
	protected boolean isImported ;
	protected int taxe ;
	protected double prix ;	
	protected int quantite;
	
	public Produit (double prix , boolean isImported, int quantite){
		this.prix=prix;
		this.isImported=isImported;
		this.quantite = quantite ;
	}
	
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	public int getTaxe() {
		return taxe;
	}
	public void setTaxe(int taxe) {
		this.taxe = taxe;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
