package operations;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
/**
 * A test class that implements a Parameterized test
 * for the IntegerOperations powerOfTwo method, 
 * 
 * @author afaros
 */
@RunWith(Parameterized.class)
public class IntegerOperationsTest_PowerofTwo_ParameterizedTest {

	@Parameter(value = 0)
	public int power;
	@Parameter(value = 1)
	public int result;

	IntegerOperations into = new IntegerOperations();

	/*
	 * The following method generates the input values for the tests.
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 2, 4 }, { 3, 8 }, { 4, 16 } };

		return Arrays.asList(data);
	}

	/*
	 * A unit test that is executed for each pair of parameters.
	 */
	@Test
	public void testPowerOfTwo() {
		Assert.assertEquals(result, into.powerOfTwo(power));
	}

}
