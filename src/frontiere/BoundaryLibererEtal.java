package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui");
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0]=="true") {
				StringBuilder description = new StringBuilder();
				description.append("Vous avez vendu ");
				description.append(donneesEtal[4]);
				description.append(" sur ");
				description.append(donneesEtal[3]);
				description.append(" ");
				description.append(donneesEtal[2]);
				description.append(".\n");
				description.append("Au revoir " + nomVendeur + ", passez une bonne journée");
			}
		}
	}
		
}
