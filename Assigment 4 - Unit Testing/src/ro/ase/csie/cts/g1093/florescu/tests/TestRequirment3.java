package ro.ase.csie.cts.g1093.florescu.tests;

import static org.junit.Assert.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.g1093.florescu.classes.Product;
import ro.ase.csie.cts.g1093.florescu.classes.ProductRulesForValidation;
import ro.ase.csie.cts.g1093.florescu.exceptions.ExceptionInvalidElementsInArrayList;
import ro.ase.csie.cts.g1093.florescu.exceptions.ExceptionInvalidName;
import ro.ase.csie.cts.g1093.florescu.exceptions.ExceptionInvalidPrice;
import ro.ase.csie.cts.g1093.florescu.exceptions.ExceptionNullArrayList;
import ro.ase.csie.cts.g1093.florescu.exceptions.ExceptionZeroElementsInArrayList;

public class TestRequirment3 {

    Product product;
	
	public static final String NAME_PRODUCT = "Product";
	public static final float PRICE_PRODUCT = ProductRulesForValidation.PRICE_MIN;
	public static final ArrayList<Integer> WEEKLY_SOLD_ITEMS = new ArrayList<Integer>();;
	public static final int NO_WEEKLY_SOLD_ITEMS = 4;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for(int i=0; i<NO_WEEKLY_SOLD_ITEMS; i++) {
			WEEKLY_SOLD_ITEMS.add(ProductRulesForValidation.SOLD_ITEMS_MIN);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		product = new Product(NAME_PRODUCT, PRICE_PRODUCT, WEEKLY_SOLD_ITEMS);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testRightGetPercentOfBadWeeks() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(1);
		productSolds.add(2);
		productSolds.add(23);
		product.setWeeklySoldItems(productSolds);
		int actualPercentage = 66;
		int expectedPercentage = product.getPercentOfBadWeeks(20);
		assertEquals(expectedPercentage, actualPercentage);
	}
	
	@Test
	public void testRightGetWeeksIndexesWithMaxSales() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList  {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(34);
		productSolds.add(23);
		productSolds.add(34);
		product.setWeeklySoldItems(productSolds);
		ArrayList<Integer> actualIndexes = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> expectedIndexes = product.getWeeksIndexWithMaxSales();
		assertArrayEquals(expectedIndexes.toArray(), actualIndexes.toArray());
	}
	

	@Test(expected = ExceptionZeroElementsInArrayList.class)
	public void testGetPercentOfBadWeeksConditionErrorSizeZero() throws ExceptionNullArrayList,  ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		try {
			product.setWeeklySoldItems(productSolds);
		}
		catch(ExceptionNullArrayList e) {
			fail("Exception..");
		}
		product.getPercentOfBadWeeks(4);
	}
	
	
	

}
