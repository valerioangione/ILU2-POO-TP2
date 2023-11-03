package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean vendeur = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!vendeur) {
			System.out.println("Je suis désolée " + nomVendeur
					+ " ,mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + " , je vais regarder si je peux trouver un étal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée " + nomVendeur + " ,je n'ai plus d'étal qui ne soit pas déjà occupé.");
			} else {
				int numEtal = installerVendeur(nomVendeur);
				if (numEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numEtal + ".");
				}
			}
		}
	}

	private int installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		System.out.println("Quel produit souhaitez-vous vendre?");
		String produit = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre");
		int numEtal = -1;
		numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		return numEtal;
	}
}
