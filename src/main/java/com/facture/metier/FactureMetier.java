package com.facture.metier;

import java.util.ArrayList;
import java.util.List;

import com.facture.model.Produit;

public class FactureMetier  implements IFactureMetier  {
	
	double sommeTaxeProduit = 0;
	double sommeProduitHTTC = 0;
	double factureTotal = 0;
/**
 * calcul de la factures total ttc et la taxe 
 * @param taxe
 * @param Phts 
 * @return
 */
	public List<Double> getSommeTotalFactureAndTaxe(List<Produit> phts) {
		
		List<Double> factureAndTaxes = new ArrayList<Double>();
		for(Produit pht : phts){
				        	 
					sommeTaxeProduit += calculTaxeProduit(pht.getTaxe() ,pht.getPrix() , pht.getQuantite(), pht.isImported());
					sommeProduitHTTC += (pht.getPrix() * pht.getQuantite());					
	           }	
		
			factureTotal = sommeProduitHTTC + sommeTaxeProduit;		
			factureAndTaxes.add(rounding(roundedTopFiveCents(factureTotal)));
			factureAndTaxes.add(rounding(roundedTopFiveCents(sommeTaxeProduit)));
			return factureAndTaxes;		
		}
/**
 * calcule du cout de chaque produit ttc 
 * @param taxe
 * @param Pht
 * @param quantite
 * @param isImporte
 * @return
 */
	public double calculFactureParProduit(int taxe, double Pht ,int quantite ,boolean isImporte) {
		
		if(isImporte){
			double taxeProduitImporte = quantite * (calculTaxeProduitImporte(taxe,  Pht));			
			return rounding(roundedTopFiveCents(taxeProduitImporte + (quantite * Pht)));
			
		}else{
			double taxeProduitLocal = calculTaxeProduitLocal(taxe,  quantite * Pht);			
			return rounding(roundedTopFiveCents(taxeProduitLocal + (quantite * Pht)));
		}

	}
/**
 * calcul de la taxe de chaque produit 
 * @param taxe
 * @param Pht
 * @param quantite
 * @param isImporte
 * @return
 */
	private double calculTaxeProduit(int taxe, double Pht ,int quantite ,boolean isImporte) {
		
		if(isImporte){
			double taxeProduitImporte = calculTaxeProduitImporte(taxe, quantite * Pht);			
			return rounding(roundedTopFiveCents(taxeProduitImporte)); 
			
		}else{
			double taxeProduitLocal = calculTaxeProduitLocal(taxe,  quantite * Pht);			
			return rounding(roundedTopFiveCents(taxeProduitLocal));
		}

	}
/**
 * calcul de la taxe de chaque produit non importé  
 * @param taxe
 * @param Pht
 * @return
 */
	private double calculTaxeProduitLocal(int taxe, double Pht) {

		double taxeProduit = (Pht* taxe /100);		
		return taxeProduit;
	}
	
/**
 * calcul de la taxe de chaque produit importé  
 * @param taxe
 * @param Pht
 * @return
 */
	private double calculTaxeProduitImporte(int taxe, double Pht) {

		double taxeProduit = ((Pht* (taxe+5)) /100);		
		return taxeProduit;
	}
/**
 * arroundi 2 chiffres apres la virgule 
 * @param round
 * @return
 */
	private double rounding(double round){
		
		return (double) Math.round(round * 100) / 100; 
	}
/**
 * arrondi aux 5 centimes supérieurs
 * @param f
 * @return
 */
	public static double roundedTopFiveCents(double f){

		return (double)Math.ceil(f / 0.05f) * 0.05f;		    
}


}
