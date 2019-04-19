package operations;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A public class containing test cases in order to test the
 * functionality of the methods in IntegerOperations class.
 * @author afaros
 *
 */

public class IntegerOperationsTest {
	
	IntegerOperations into = new IntegerOperations();
	/*
	 * Positive input Test case
	 */
	@Test
	public void test_ReverseSign_positive() {
		Assert.assertEquals(-1,into.reverseSign(1));
	}
	/*
	 * Negative input Test case
	 */
	@Test
	public void test_ReverseSign_negative() {
		Assert.assertEquals(1,into.reverseSign(-1));
	}
	/*
	 * Zero as input Test case
	 */
	@Test
	public void test_ReverseSign_zero() {
		Assert.assertEquals(0,into.reverseSign(0));
	}
	/*
	 * Positives input Test case
	 */
	@Test
	public void test_Add_positives() {
		Assert.assertEquals(5,into.add(2,3));
	}
	/*
	 * Negatives input , expected exception as output
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_Add_both_negatives() {
		into.add(-2,-3);
	}
	/*
	 * One negative input , expected exception as output
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_Add_one_negative() {
		into.add(2,-3);
	}
	/*
	 * Integer overflow input , expected exception as output
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_Add_maxInteger() {
		into.add(Integer.MAX_VALUE,1);
	}
	/*
	 * Test case implementing @Rule for the Exceptions thrown
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_power_of_two_negative() {
		thrown.expect(IllegalArgumentException.class);
		into.powerOfTwo(-1);
	}
	/*
	 * Test case implementing @Rule for the Exceptions thrown
	 */
	@Test
	public void test_power_of_two_max_integer() {
		thrown.expect(IllegalArgumentException.class);
		into.powerOfTwo(32);
	}
	/*
	 * Zero as input , expected 1 as output
	 */
	@Test
	public void test_power_of_Two_zero() {
		Assert.assertEquals(1,into.powerOfTwo(0));
	}
	/*
	 * 1 as input , expected 2 as output
	 */
	@Test
	public void test_power_of_Two_one() {
		Assert.assertEquals(2,into.powerOfTwo(1));
	}
	

}
