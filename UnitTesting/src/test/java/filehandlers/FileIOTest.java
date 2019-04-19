package filehandlers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * A public class implementing test cases for the class FileIO 
 * testing normal behavior and also Exception cases.
 * @author afaros
 *
 */
public class FileIOTest {
	int [] array;
	FileIO file = new FileIO();
	/*
	 * Initial status of the array in order to be checked in each test
	 * case
	 */
	@Before
	public void initializeArray() {
		array = new int [] {1,2,3,4,5,6,7,8,9,10};
	}
	/*
	 * Test case implementing a valid input execution
	 */
	@Test
	public void test_reafFile_validinput() {
		Assert.assertArrayEquals(array,file.readFile("src/test/resources/validinputs.txt"));
	}
	/*
	 * Test case implementing a File Not Found Execution
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_withoutfile() {
		file.readFile("src/test/resources/wrong.txt");
	}
	/*
	 * Test case implementing an invalid input Execution
	 */
	@Test (expected = NumberFormatException.class)
	public void test_readFile_invalidinput() {
		file.readFile("src/test/resources/invalidinputs.txt");
	}
}
