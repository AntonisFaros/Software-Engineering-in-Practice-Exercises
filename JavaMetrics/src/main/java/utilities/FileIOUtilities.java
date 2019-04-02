package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOUtilities {

	/**
	 * @author afaros A class containing two static methods who read from a txt file
	 *         and write to it
	 */
	/**
	 * A method that receives a string as input which is the path where the file is
	 * located and reads all data from the file into an ArrayList.
	 * 
	 * @param filepath
	 */
	public static ArrayList<String> readFile(String filepath) {
		Scanner s = null;
		try {
			s = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()) {
			list.add(s.nextLine());
		}
		return list;
	}

	/**
	 * A method for writing data on a txt file
	 * 
	 * @param data     : what we need to write on the file
	 * @param filepath : the path to the file we wish to write
	 */

	public static void writeIntoFile(String data) {

		File dir = new File("tmp/test");
		dir.mkdirs();
		File tmp = new File(dir, "metrics.txt");
		try {
			if (!tmp.exists())
				tmp.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileWriter fr = null;
		try {
			fr = new FileWriter(tmp);
			fr.write(data);
			fr.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close resources
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
