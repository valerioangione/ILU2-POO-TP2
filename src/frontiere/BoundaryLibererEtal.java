package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0] == "true") {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2]
						+ ".\n" + "Au revoir " + nomVendeur + ", passez une bonne journée.");
			} else {
				System.out.println("Mais vous n'avez pas d'étal à libérer, voulez vous un biscuit?");
			}
		}
	}

}
