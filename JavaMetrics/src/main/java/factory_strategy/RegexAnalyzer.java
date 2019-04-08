package factory_strategy;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class contributing to the strategy pattern The class calculates the metrics
 * for the java code required using regular expressions.
 * 
 * @author afaros
 *
 */
public class RegexAnalyzer extends Analyzer {
	/**
	 * A public method calculating lines of java code in the file It calculates the
	 * blank lines, the commented lines an the total lines. Finally it substracts
	 * the comments and blank lines from the total in order to calculate the lines
	 * of actual code.
	 */
	@Override
	public void getLoc(ArrayList<String> data) {

		String patternblanks = "^\\s*$";
		String patterncomments = "//*";
		Pattern blanklines = Pattern.compile(patternblanks);
		Pattern comms = Pattern.compile(patterncomments);
		int blines = 0;
		int lines = 0;
		int comments = 0;
		Matcher mat;
		for (String temp : data) {
			lines++;
			mat = blanklines.matcher(temp);
			while (mat.find()) {
				blines++;
			}
			mat.reset();
			mat = comms.matcher(temp);
			while (mat.find()) {
				comments++;
			}

		}

		loc = lines - blines - comments;
	}

	/**
	 * A public method calculating the number of classes in a java file using
	 * regular expressions
	 */
	@Override
	public void getNoc(ArrayList<String> data) {
		
		String ndata;
		StringBuilder sb = new StringBuilder();
		for (String temp :data) {
			sb.append(temp);
		}
		ndata = sb.toString();
		Pattern pattern = Pattern.compile("\\bclass");
		Matcher matcher = pattern.matcher(ndata);
		int classcount = 0;
		while (matcher.find()) {

			classcount++;
			
		}
		
		noc = classcount;
		
	}

	/**
	 * a public method that calculates the number of methods in a java file using
	 * regular expressions
	 */
	@Override
	public void getNom(ArrayList<String> data) {
		String pattern = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";

		Pattern methods = Pattern.compile(pattern);

		int methodcounter = 0;
		Matcher mat;
		for (String temp : data) {

			mat = methods.matcher(temp);
			while (mat.find()) {
				methodcounter++;
			}

		}
		nom = methodcounter;
	}

	@Override
	public int getloc() {
		return loc;
	}

	@Override
	public int getnoc() {
		return noc;
	}

	@Override
	public int getnom() {
		return nom;
	}

}
