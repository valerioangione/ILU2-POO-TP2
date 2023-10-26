package controleur;


import villagegaulois.Village;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,Village village) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
		this.village = village;
	}
	
	public Boolean isVendeur(String nomVendeur) {
		return village.rechercherEtal(village.trouverHabitant(nomVendeur)) != null;
	}

	public String[] libererEtal(String nomVendeur) {
		if (village.rechercherEtal(village.trouverHabitant(nomVendeur)) != null) {
			String[] donneesEtal =village.rechercherEtal(village.trouverHabitant(nomVendeur)).etatEtal();
			village.partirVendeur(village.trouverHabitant(nomVendeur));
			return donneesEtal;
		}else {
			return null;
		}
	}
}
