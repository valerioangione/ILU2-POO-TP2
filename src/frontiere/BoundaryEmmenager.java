package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenu villageois " + nomVisiteur);
		StringBuilder question2 = new StringBuilder();
		question2.append("Quelle est votre force?");
		int forceVisiteur = Clavier.entrerEntier(question2.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceVisiteur);
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenu druide " + nomVisiteur);
		StringBuilder question3 = new StringBuilder();
		question3.append("Quelle est votre force?");
		int forceDruide = Clavier.entrerEntier(question3.toString());
		int effetPotionMin = -1;
		int effetPotionMax = -2;
		while (effetPotionMin > effetPotionMax) {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force la plus faible que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force la plus forte que vous produisez ?");
			if (effetPotionMin > effetPotionMax) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
