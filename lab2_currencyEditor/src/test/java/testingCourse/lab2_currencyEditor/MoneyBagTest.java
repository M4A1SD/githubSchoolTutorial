package testingCourse.lab2_currencyEditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyBagTest
{
	private MoneyBag moneyBag;

	@BeforeEach
	public void setUp() throws Exception
	{
		Money bagILS[] = {new Money(10, "ILS"), new Money(10, "EUR")};
		moneyBag = new MoneyBag(bagILS);
	}

	// checking functionality: adding positive number to MoneyBag
	// input data: 10 ILS
	// expected result: 20 ILS, money balance increased
	@Test
	public void testAddMoney_Positive()
	{
		Money expectedPOS10 = new Money(20, "ILS");
		Money bag[] = {new Money(10,"ILS")};
		MoneyBag res = new MoneyBag(bag);
		assertEquals(expectedPOS10 , res.add(new Money(10,"ILS")));
	}

	// checking functionality: adding negative number to MoneyBag, and also seeing zero as an output
	// input data: -10 ILS
	// expected result: 0 ILS, money balance decreased
	@Test
	public void testAddMoney_Negative()
	{
		Money expectedNeg10 = new Money(0, "ILS");
		Money bag[] = {new Money(10,"ILS")};
		MoneyBag res = new MoneyBag(bag);
		assertEquals(expectedNeg10, res.addMoney(new Money(-10, "ILS"))));
	}

	// checking functionality: adding 0 Money to MoneyBag
	// input data: 0 ILS
	// expected result: 10 ILS, expecting balance to not change
	@Test
	public void testAddMoney_zeroAdd()
	{
		Money expected10 = new Money(10, "ILS");
		assertTrue(expected10.equals(moneyBag.addMoney(new Money(0, "ILS"))));
	}


	// checking functionality: adding different money currency to MoneyBag
	// input data: 10 USD
	// expected result: 10 USD , 10 ILS
	@Test
	public void testAddMoney_Different()
	{
		Money bagDiff[]= {new Money(10, "USD"), new Money(10, "ILS")};
		MoneyBag expectedTwoDiffCurrs = new MoneyBag(bagDiff);
		assertTrue(expectedTwoDiffCurrs.equals(moneyBag.addMoney(new Money(10, "USD"))));
	}


	// Add Null
	// add Money to a Null money bag
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////


	// checking functionality: checking if 10 ILS is in the MoneyBag
	// input data: 10 ILS
	// expected result:True
	@Test
	public void testContains_bagILS()
	{
		assertTrue(moneyBag.contains(new Money(10, "ILS")));
	}

	// checking functionality: checking if 20 ILS is in the MoneyBag
	// input data: 20 ILS
	// expected result:False
	@Test
	public void testContains_NotInbag()
	{
		assertFalse(moneyBag.contains(new Money(20, "ILS")));
	}

	// checking functionality: checking if 10 USD is in the MoneyBag
	// input data: 10 USD
	// expected result:False
	@Test
	public void testContains_bagNotILS()
	{
		try
		{
			assertFalse(moneyBag.contains(new Money(20, "USD")));
		}
		//exception: can't compare to Null
		catch(Exception e) {assertFalse(true);}
	}

	// checking functionality: checking if 0 ILS is in the MoneyBag
	// input data: 0 ILS
	// expected result:False
	@Test
	public void testContains_zeroILS()
	{
		assertFalse(moneyBag.contains(new Money(0, "ILS")));
	}


	// check 



}
