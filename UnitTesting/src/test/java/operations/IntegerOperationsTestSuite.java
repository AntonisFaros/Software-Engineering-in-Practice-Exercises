package operations;

import org.junit.runner.RunWith;
/**
 *A public class implementing a test suite for
 *the tests IntegerOperationsTest_powerOfTwo_ParemeterizedTest
 *and IntegerOperationsTest
 *
 */
public class IntegerOperationsTestSuite {
	@RunWith(Suite.class)
	@Suite.SuiteClasses({IntegerOperationsTest.class, IntegerOperationsTest_PowerofTwo_ParameterizedTest.class})
	public class MyMathTestSuite {
		/*
		 * This class remains empty. Is used only as a holder 
		 * of the above annotations.
		 */
	}

}
