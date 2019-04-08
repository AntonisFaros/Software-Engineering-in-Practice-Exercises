package factory_strategy;

import java.util.ArrayList;

/**
 * 
 * @author afaros
 * 
 *         public class contributing to strategy pattern the class overrides the
 *         Analyzer methods in order to calculate metrics of the java code using
 *         String comparison
 */
public class StringAnalyzer extends Analyzer {

	@Override
	public void getLoc(ArrayList<String> data) {

		boolean comment = false;
		for (String line : data) {
			if (line.contains("/*")) {
				comment = true;
				continue;
			}
			if (line.contains("*/")) {
				comment = false;
				continue;
			}
			if (line.contains("//")) {
				continue;
			}
			if (line.trim().isEmpty()) {
				continue;
			}
			if (!comment) {
				loc++;
			}

		}

	}

	@Override
	public void getNoc(ArrayList<String> data) {
		for (String line : data) {
			if (line.contains("public class")) {
				noc++;
			}
		}

	}

	@Override
	public void getNom(ArrayList<String> data) {

		for (String line : data) {
			String nline = line.trim();
			if (nline.contains("(") && nline.contains(")") && nline.endsWith("{")) {
				nom++;
			}

		}
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
