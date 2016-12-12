package jeudego;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GroupeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("* Classe GroupeTest: @BeforeClass method");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("* Classe GroupeTest: @AfterClass method");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("* Classe GroupeTest: @Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("* Classe GroupeTest: @After method");
	}


	@Test
	public void testGetGroupe() {
		ArrayList<Pierre> groupe = Groupe.groupe;
		assertEquals(0, groupe.size());
	}

	@Test
	public void testAjouterPierre() {
		Pierre pierre = new Pierre(10, 10, Color.red);
		Groupe.ajouterPierre(pierre);
		assertEquals(0, Groupe.groupe.size());
	}


	@Test
	public void affichageGroupe() {
		Groupe.affichageGroupe();
	}


}
