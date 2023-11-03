package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ ", mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			Gaulois[] vendeurProduit = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeurProduit.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				// TODO
			}
		}
	}

}
