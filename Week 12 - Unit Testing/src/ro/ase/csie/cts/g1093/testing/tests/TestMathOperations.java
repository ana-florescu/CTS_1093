package ro.ase.csie.cts.g1093.testing.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.g1093.testing.models.MathOperations;

public class TestMathOperations {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("hello");
		//Initialize the data from a database
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("bye");
		//logical destructor
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("preparing the test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("cleaning after the test");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddNormalValues() {
		int a = 5;
		int b = 6;
		int expectedResult = 11;
		int actualResult = MathOperations.add(a, b);
		assertEquals("Adding 5 and 6", expectedResult, actualResult);
		
	}
	
	

}
