package operations;

import org.junit.Assert;

import org.junit.Test;

import filehandlers.FileIO;

import static org.mockito.Mockito.*;
/**
 * 
 * @author afaros
 *A public class implementing test cases using the Mockito dependency
 * in order to mock connected classes of the class ArrayOperations
 */
public class ArrayOperationsTest {
	/*
	 * Initial creation of FileIO and IntegerOperations mocks
	 * in order to create an ArrayOperations Object
	 */
	IntegerOperations io = mock(IntegerOperations.class);
	FileIO file = mock(FileIO.class);
	ArrayOperations arro = new ArrayOperations(file, io);
	/*
	 * Test case implementing a mock of the class FileIO
	 * in order to test the functionality of the method findMaxInFile 
	 * of the ArrayOperations class.
	 */
	@Test
	public void test_findMaxInFile_Mocking() {

		when(file.readFile("src/test/resources/validinputs.txt"))
				.thenReturn(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		when(file.readFile("src/test/resources/invalidinputs.txt")).thenThrow(NumberFormatException.class);
		when(file.readFile("src/test/resources/wrong.txt")).thenThrow(IllegalArgumentException.class);
		
		Assert.assertEquals(10, arro.findMaxInFile("src/test/resources/validinputs.txt"));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_findMaxInFile_Mocking_Exceptions() {
		when(file.readFile("src/test/resources/emptyfile.txt")).thenThrow(IllegalArgumentException.class);
		arro.findMaxInFile("src/test/resources/emptyfile.txt");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_reverseFile_Mocking_Exceptions() {
		when(file.readFile("src/test/resources/emptyfile.txt")).thenThrow(IllegalArgumentException.class);
		arro.reverseArray("src/test/resources/emptyfile.txt");
	}
	

	/*
	 * Test case implementing mocks of the classes FileIO and IntegerOperations
	 * in order to test the functionality of the reverseArray method of 
	 * ArrayOperations class.
	 */
	@Test
	public void test_reverseArray_Mocking() {

		when(file.readFile("src/test/resources/validinputs.txt"))
				.thenReturn(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		when(io.reverseSign(1)).thenReturn(-1);
		when(io.reverseSign(2)).thenReturn(-2);
		when(io.reverseSign(3)).thenReturn(-3);
		when(io.reverseSign(4)).thenReturn(-4);
		when(io.reverseSign(5)).thenReturn(-5);
		when(io.reverseSign(6)).thenReturn(-6);
		when(io.reverseSign(7)).thenReturn(-7);
		when(io.reverseSign(8)).thenReturn(-8);
		when(io.reverseSign(9)).thenReturn(-9);
		when(io.reverseSign(10)).thenReturn(-10);

		
		int[] testReversed = { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 };
		Assert.assertArrayEquals(testReversed, arro.reverseArray("src/test/resources/validinputs.txt"));
	}

}
