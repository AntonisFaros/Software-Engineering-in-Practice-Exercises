import facade.Facade;

/**
 * 
 */

/**
 * @author afaros Client class for creating a Facade object in order to start
 *         the analysis of the Java code
 *         The final results are printed in a directory called tmp/test/metrics.txt
 *         in the root folder
 */
public class JavaMetrics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Facade start = new Facade();
		start.analyzeJava(args[0], args[1]);

	}

}
