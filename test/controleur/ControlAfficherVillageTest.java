package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("aaa", 1);
		controlEmmenager.ajouterGaulois("bbb", 2);
		boolean trouve = false;
		for (String villageois : controlAfficherVillage.donnerNomsVillageois()) {
			if (villageois.equals("aaa"))
				trouve = true;
		}
		assertTrue(trouve);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
