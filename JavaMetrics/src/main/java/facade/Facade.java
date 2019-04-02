package facade;

import java.util.ArrayList;

import factory_strategy.Analyzer;

/**
 * A class implementing Facade Design Pattern in order to read,analyze 
 * and write the java metrics calculated on a CSV file.
 */

/**
 * @author afaros
 *
 */
public class Facade {

	ArrayList<String> input;

	/**
	 * public method to handle the computation of the metrics of the java code
	 * 
	 * @param                  file, the path of the file containing the java code
	 * @param type_of_analysis , insrted by user between "regex" and "string"
	 */
	public void analyzeJava(String file, String type_of_analysis) {
		ArrayList<String> data = readSourceCode(file);
		String metrics = calculateMetrics(data, type_of_analysis);
		writeCSV(metrics);
	}

	public ArrayList<String> readSourceCode(String filepath) {
		input = utilities.FileIOUtilities.readFile(filepath);
		return input;

	}

	/**
	 * public method in order to create an Analyzer object depending on the type of
	 * analysis the user requires. The metrics of the analysis are calculated
	 * afterwards and inserted on a string.
	 **/
	public String calculateMetrics(ArrayList<String> data, String analysis) {

		Analyzer anz = factory_strategy.AnalyzerFactory.createAnalyzer(analysis);

		anz.getLoc(data);
		anz.getNoc(data);
		anz.getNom(data);

		String metrics;
		metrics = (" Lines of code: " + Integer.toString(anz.getloc()) + " Number of classes: "
				+ Integer.toString(anz.getnoc()) + " Number of methods: " + Integer.toString(anz.getnom()));

		return metrics;
	}

	public void writeCSV(String data) {
		utilities.FileIOUtilities.writeIntoFile(data);

	}

}
