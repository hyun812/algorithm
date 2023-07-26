import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(bf.readLine());
    	
    	int cnt = 2*n-1;
    	int start = 1;
//    	1,3,5,7,9
//    	2,4,6,8,10
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<(cnt-start)/2; j++) {
    			System.out.print(" ");
    		}
    		
    		for(int j=0; j<start; j++) {
    			System.out.print("*");
    		}
    		start +=2;
    		System.out.println();
    	}
    	
    	start -= 4;
    	for(int i=0; i<n-1; i++) {
    		for(int j=0; j<(cnt-start)/2; j++) {
    			System.out.print(" ");
    		}
    		
    		for(int j=0; j<start; j++) {
    			System.out.print("*");
    		}
    		start -=2;
    		if(i!=n) System.out.println();
    		
    	}
    	
    	
    	
    }
}