package jeudego;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameStartTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("* Classe GameStartTest: @BeforeClass method");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("* Classe GameStartTest: @AfterClass method");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("* Classe GameStartTest: @Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("* Classe GameStartTest: @After method");
	}

	@Test
	public void testMain() {
		System.out.println("Test de la fonction Main");
	}
}
