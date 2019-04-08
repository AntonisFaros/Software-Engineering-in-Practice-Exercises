import facade.CodeAnalyzer;

/**
 * 
 */

/**
 * @author afaros Client class for creating a Code Analyzer object in order to start
 *         the analysis of the Java code
 *         The final results are printed in a directory called tmp/test/metrics.txt
 *         in the root folder
 */
public class JavaMetrics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CodeAnalyzer start = new CodeAnalyzer();
		start.analyzeJava(args[0], args[1]);
		System.out.println("Done. The metrics from the file you inserted are in the folder tmp/test on the project's root directory !");

	}

}
