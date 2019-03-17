import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author agkortzis The purpose of this class is to demonstrate a simple
 *         scenario of a JFreeChart XYLine chart.
 */
public class JFreeChartXYLineChart {

	/***
		 * Receives a single dimension Integer array. From this array the dataset
		 * that will be used for the visualization is generated. Finally, The chart
		 * is generated with the use of the aforementioned dataset and then
		 * presented in the screen.
		 * 
		 * @param dataValues Single dimension integer array
		 */
		public void generateChart(int[] dataValues) {
			/*
			 * The XYSeriesCollection object is a set XYSeries series (dataset) that
			 * can be visualized in the same chart
			 */
			XYSeriesCollection dataset = new XYSeriesCollection();
			/*
			 * The XYSeries that are loaded in the dataset. There might be many
			 * series in one dataset.
			 */
			XYSeries data = new XYSeries("grades");

			/*
			 * Populating the XYSeries data object from the input Integer array
			 * values.
			 */
			for (int i = 0; i < dataValues.length; i++) {
				data.add(i, dataValues[i]);
			}

			// add the series to the dataset
			dataset.addSeries(data);

			boolean legend = false; // do not visualize a legend
			boolean tooltips = false; // do not visualize tooltips
			boolean urls = false; // do not visualize urls
			

			// Declare and initialize a createXYLineChart JFreeChart
			JFreeChart chart = ChartFactory.createXYLineChart("Grade Histogram", "Grades", "Frequency", dataset,
					PlotOrientation.VERTICAL, legend, tooltips, urls);
			
			//Create a NumberAxis in order to get integers on the x-axis
			NumberAxis xAxis = new NumberAxis();
			xAxis.setTickUnit(new NumberTickUnit(1));

			// Assign it to the chart
			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setDomainAxis(xAxis);

			/*
			 * Initialize a frame for visualizing the chart and attach the
			 * previously created chart.
			 */
			ChartFrame frame = new ChartFrame("Grade Chart", chart);
			frame.pack();
			// makes the previously created frame visible
			frame.setVisible(true);
		}
		public static void main(String[] args) {
			int data [] = {1,4,3,5,6,7,8,9,10,1,0};
			JFreeChartXYLineChart demo = new JFreeChartXYLineChart();
			demo.generateChart(data);
		}
}
