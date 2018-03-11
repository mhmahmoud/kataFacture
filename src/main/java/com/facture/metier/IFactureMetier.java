package com.facture.metier;

import java.util.List;

import com.facture.model.Produit;
	
public interface IFactureMetier {
	
	public List<Double> getSommeTotalFactureAndTaxe(List<Produit> list);

	double calculFactureParProduit(int taxe, double Pht,int quantite, boolean isImporte);


}
