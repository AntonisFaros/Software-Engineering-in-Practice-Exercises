
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Scanner;

public class HistogramGenerator {
/***
 * @author afaros
 * @param args
 * The purpose of this class is to demonstrate an example of creating a JFreeChart by 
 * taking as input a .txt file including grades [0,10]
 */
	
	public static void main(String args[])  {

		int[] data = new int[11];
		Scanner input = null;
		if (args.length < 1) {
		  System.out.println("Faulty insert of data");
		  System.exit(1);
		  
		}
		try {
			input = new Scanner(new FileInputStream(args[0]));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		
		while (input.hasNext()) {
			data[input.nextInt()]++; 

		}
		input.close();
	
		JFreeChartXYLineChart demo  = new JFreeChartXYLineChart();
		demo.generateChart(data);		 
	}
	
	

}
