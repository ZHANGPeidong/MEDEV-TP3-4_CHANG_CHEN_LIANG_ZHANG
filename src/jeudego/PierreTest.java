package jeudego;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PierreTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("* Classe PierreTest: @BeforeClass method");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("* Classe PierreTest: @AfterClass method");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("* Classe PierreTest: @Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("* Classe PierreTest: @After method");
	}


	@Test
	public void testPierreIntIntColor() {
		Pierre pierre = new Pierre(10,10,Color.white);
		boolean flag = pierre.isSameColor(Color.red);
		assertEquals(false, flag);
	}

}
