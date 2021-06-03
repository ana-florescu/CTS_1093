package ro.ase.csie.cts.g1093.florescu.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

public class TestRequirment2 {

    Product product;
	
	public static final String NAME_PRODUCT = "Product";
	public static final float PRICE_PRODUCT = ProductRulesForValidation.PRICE_MIN;
	public static final ArrayList<Integer> WEEKLY_SOLD_ITEMS = new ArrayList<Integer>();
	public static final int NO_WEEKLY_SOLD_ITEMS = 4;
	
	public static final ArrayList<Integer> WEEKLY_SOLD_ITEMS_PERF_TEST = new ArrayList<Integer>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for(int i=0; i<NO_WEEKLY_SOLD_ITEMS; i++) {
			WEEKLY_SOLD_ITEMS.add(ProductRulesForValidation.SOLD_ITEMS_MIN);
		}
		
		for(int i = 0; i < ProductRulesForValidation.SOLD_ITEMS_MAX; i++) {
			WEEKLY_SOLD_ITEMS_PERF_TEST.add(ProductRulesForValidation.SOLD_ITEMS_MIN+1);
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
	
	@Test(expected = ExceptionInvalidPrice.class)
	public void testSetPriceErrorCondition() throws ExceptionInvalidPrice {
		product.setPrice(ProductRulesForValidation.PRICE_MAX);
	}
	
	@Test
	public void testSetPriceBoundary() throws ExceptionInvalidPrice {
		product.setPrice(ProductRulesForValidation.PRICE_MAX - 1);
	}
	
	
	@Test
	public void testAddWeekRight() throws ExceptionInvalidElementsInArrayList, ExceptionNullArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(10);
		product.setWeeklySoldItems(productSolds);
		int actualAddedSold = 10;
		int expectedAddedSold = product.getSoldItems(product.getWeeklySoldItems().size());
		assertEquals(expectedAddedSold, actualAddedSold);
		
	}
	
	@Test
	public void testGetSoldItemsRight() throws ExceptionZeroElementsInArrayList, ExceptionNullArrayList, ExceptionInvalidElementsInArrayList{
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(40);
		productSolds.add(8);
		product.setWeeklySoldItems(productSolds);
		int actualSolds = 8;
		int expectedSolds = product.getSoldItems(1);
		assertEquals(expectedSolds, actualSolds);
	}
	
	@Test
	public void testGetNoWeeksAboveLimitRight() throws ExceptionInvalidElementsInArrayList, ExceptionNullArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(4);
		productSolds.add(9);
		product.setWeeklySoldItems(productSolds);
		int actualNo = 2;
		int expectedNo = product.getNoWeeksAboveLimit(3);
		assertEquals(expectedNo, actualNo);
	}
	
	@Test(expected = ExceptionInvalidElementsInArrayList.class)
	public void testAddWeekRange() throws ExceptionInvalidElementsInArrayList {
		product.addWeek(ProductRulesForValidation.SOLD_ITEMS_MAX + 1);
	}
	
	@Test(expected = ExceptionZeroElementsInArrayList.class)
	public void testGetSoldItemsRange() throws ExceptionNullArrayList,
	   ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> solds = new ArrayList<Integer>();
		product.setWeeklySoldItems(solds);
		product.getSoldItems(0);
	}
	
	@Test(expected = ExceptionInvalidElementsInArrayList.class)
	public void testGetNoWeeksAboveLimitRange() throws ExceptionInvalidElementsInArrayList {
		product.getNoWeeksAboveLimit(-9);
	}
	

	@Test
	public void testAddWeekBoundaryLowerLimit() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(90);
		productSolds.add(20);
		product.setWeeklySoldItems(productSolds);
		product.addWeek(ProductRulesForValidation.SOLD_ITEMS_MIN);
		int actualAddedSolds = ProductRulesForValidation.SOLD_ITEMS_MIN;
		int expectedAddedSolds = product.getSoldItems(product.getWeeklySoldItems().size());
		assertEquals(expectedAddedSolds, actualAddedSolds);
	}
	

	@Test
	public void testAddWeekBoundaryUpperLimit() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(90);
		productSolds.add(20);
		product.setWeeklySoldItems(productSolds);
		product.addWeek(ProductRulesForValidation.SOLD_ITEMS_MAX);
		int actualAddedSolds = ProductRulesForValidation.SOLD_ITEMS_MAX;
		int expectedAddedSolds = product.getSoldItems(product.getWeeklySoldItems().size()-1);
		assertEquals(expectedAddedSolds, actualAddedSolds);
	}
	
	@Test
	public void testGetSoldItemsBoundaryLowerLimit() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(55);
		productSolds.add(ProductRulesForValidation.SOLD_ITEMS_MIN);
		product.setWeeklySoldItems(productSolds);
		int actualSolds = ProductRulesForValidation.SOLD_ITEMS_MIN;
		int expectedSolds = product.getSoldItems(1);
		assertEquals(expectedSolds, actualSolds);
	}
	
	
	@Test
	public void testGetSoldItemsBoundaryUpperLimit() throws ExceptionNullArrayList,ExceptionInvalidElementsInArrayList, ExceptionZeroElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(55);
		productSolds.add(ProductRulesForValidation.SOLD_ITEMS_MIN);
		product.setWeeklySoldItems(productSolds);
		int actualSolds = ProductRulesForValidation.SOLD_ITEMS_MIN;
		int expectedSolds = product.getSoldItems(1);
		assertEquals(expectedSolds, actualSolds);
	}
	
	@Test
	public void testGetNoWeeksBoundaryLowerLimitAboveLimit() throws ExceptionInvalidElementsInArrayList {
		int actualNo = 0;
		int expectedNo = product.getNoWeeksAboveLimit(ProductRulesForValidation.SOLD_ITEMS_MIN);
		assertEquals(expectedNo, actualNo);
	}
	
	@Test
	public void testGetNoWeeksCardinalityTwoAboveLimit() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(7);
		productSolds.add(1);
		product.setWeeklySoldItems(productSolds);
		int actualNo = 2;
		int expectedNo = product.getNoWeeksAboveLimit(ProductRulesForValidation.SOLD_ITEMS_MIN);
		assertEquals(expectedNo, actualNo);
	}
	
	@Test
	public void testGetNoWeeksCardinalityFiveAboveLimit() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList {
		ArrayList<Integer> productSolds = new ArrayList<Integer>();
		productSolds.add(67);
		productSolds.add(12);
		productSolds.add(45);
		productSolds.add(10);
		productSolds.add(4);
		product.setWeeklySoldItems(productSolds);
		int actualNo = 2;
		int expectedNo = product.getNoWeeksAboveLimit(40);
		assertEquals(expectedNo, actualNo);
	}
	
	@Test
	public void testPerformanceGetNoWeeksAboveLimit() throws ExceptionNullArrayList, ExceptionInvalidElementsInArrayList {
		product.setWeeklySoldItems(WEEKLY_SOLD_ITEMS_PERF_TEST);
		int actualNo = WEEKLY_SOLD_ITEMS_PERF_TEST.size();
		int expectedNo = product.getNoWeeksAboveLimit(ProductRulesForValidation.SOLD_ITEMS_MIN);
		assertEquals(expectedNo, actualNo);
	}
	

}
