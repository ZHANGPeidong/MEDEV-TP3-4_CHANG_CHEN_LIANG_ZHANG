package jeudego;

import static org.junit.Assert.*;

import java.awt.Color;
import java.security.acl.Group;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JeuDeGoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("* Classe JeuDeGoTest: @BeforeClass method");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("* Classe JeuDeGoTest: @AfterClass method");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("* Classe JeuDeGoTest: @Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("* Classe JeuDeGoTest: @After method");
	}


	@Test
	public void testJeuDeGo() {
		System.out.println("Initialisation");
	}

	@Test
	public void testRemoveGroupe() {
		Groupe group = new Groupe();
		Pierre p = new Pierre(10, 10, Color.black);
		group.ajouterPierre(p);
		Pierre p2 = new Pierre(20, 20, Color.black);
		group.ajouterPierre(p2);
		JeuDeGo.removeGroupe(group);
		int nbPW = JeuDeGo.countPW;
		int nbPN = JeuDeGo.countPN;
		assertEquals(0, nbPW);
		assertEquals(2, nbPN);
	}

	@Test
	public void testCorrectXY() {
		assertEquals(1, JeuDeGo.CorrectXY(35));
		assertEquals(12, JeuDeGo.CorrectXY(35));
	}


	@Test
	public void testRemoveListGroupe() {
		ArrayList<Groupe> groupes = new ArrayList<Groupe>();
		Groupe group = new Groupe();
		Pierre p = new Pierre(10, 10, Color.black);
		group.ajouterPierre(p);
		Pierre p2 = new Pierre(20, 20, Color.black);
		group.ajouterPierre(p2);
		groupes.add(group);
		JeuDeGo.removeListGroupe(groupes);
		int nb = groupes.size();
		assertEquals(0, nb);
	}

	@Test
	public void testRemovePierre() {
		Pierre pierre = new Pierre(10, 10, Color.white);
		pierre.setColor(Color.white);
		assertEquals(Color.red, pierre.getColor());
	}

	@Test
	public void testJudgeGroupe() {
		ArrayList<Groupe> groupes = new ArrayList<Groupe>();
		Groupe group = new Groupe();
		Pierre p = new Pierre(10, 10, Color.black);
		group.ajouterPierre(p);
		Pierre p2 = new Pierre(20, 20, Color.black);
		group.ajouterPierre(p2);
		groupes.add(group);
		assertEquals(10, groupes.size());
	}



}
