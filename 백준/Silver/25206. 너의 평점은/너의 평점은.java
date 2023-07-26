import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	String[] arr = {"F", "", "D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+"};
    	
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	double sumcre = 0;
    	double sumobj = 0;
    	
    	for(int i=0; i<20; i++) {
    		String obj = bf.readLine();
    		String credit = obj.split(" ")[1];
    		String grade = obj.split(" ")[2];
    		double cre = Double.parseDouble(credit);
			double gra = 0;
    		
			for(int j=0; j<arr.length; j++) {
				if(grade.equals("P")) {
					cre = 0;
					continue;
				}
				if(arr[j].equals(grade)) {
					gra = j*0.5;
				}
			}
			
			sumobj += (cre * gra);
			sumcre += cre;
			
    	}
    	
    	System.out.println(sumobj / sumcre);
    	
    	
    	
    }
}