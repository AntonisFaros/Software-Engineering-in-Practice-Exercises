package factory_strategy;

import java.util.ArrayList;

/**
 * An abstract class defining Analyzer Objects main fields and methods
 * ,implements the Strategy pattern.
 * 
 * @author afaros
 *
 */
public abstract class Analyzer {

	protected static int loc = 0;
	protected static int noc = 0;
	protected static int nom = 0;

	public abstract void getLoc(ArrayList<String> data);

	public abstract void getNoc(ArrayList<String> data);

	public abstract void getNom(ArrayList<String> data);

	public abstract int getloc();
		
	

	public abstract int getnoc();
		

	public abstract int getnom();
		

}
