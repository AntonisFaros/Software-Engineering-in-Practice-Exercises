package factory_strategy;

/**
 * @author afaros A class implementing the Factory pattern in order to create
 *         Analyzer Objects
 * 
 */
public class AnalyzerFactory {
	/**
	 * A method to return the specific analyzer depending on the type of analysis to
	 * be executed.
	 * 
	 * type , type of analysis to be executed
	 * 
	 */
	public static Analyzer createAnalyzer(String type) {
		Analyzer anz = null;
		if (type.equals("regex")) {
			anz = new RegexAnalyzer();
		} else if (type.equals("string")) {
			anz = new StringAnalyzer();
		}
		return anz;
		
	}
}
