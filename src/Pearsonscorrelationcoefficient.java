import java.util.ArrayList;
import java.util.Scanner;


public class Pearsonscorrelationcoefficient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Double> serieX = new ArrayList<Double>();
		ArrayList<Double> serieY = new ArrayList<Double>();
		while(in.hasNextLine()){
			String line = in.nextLine();
			if(line.equals("-")) break;
			else{
				String[] split = line.split("\\s+");
				serieX.add(Double.parseDouble(split[0]));
				serieY.add(Double.parseDouble(split[1]));
			}
			
		}
		

	}
	
	public static double getMean(ArrayList<Double> list){
		double sum = 0;
		for(double d : list)
			sum += d;
		
		return sum/list.size();
	}
	
	public static double getSTD(ArrayList<Double> list){
		double mean = getMean(list);
		double sum = 0;
		for(double d : list)
			sum += (d-mean)*(d-mean);
				
		return Math.sqrt(sum/list.size());
	}

}
