
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	String inp = st.nextToken();
    	
    	String[] arr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    	int result = 0;
    	for(int i=0; i<inp.length(); i++) {
    		for(int j=0; j<arr.length; j++) {
    			String target = inp.split("")[i];
    			if(arr[j].contains(target)) {
    				result += j+3;
    			}
    			
    			
    			
    		}
    	}
    	
    	
    	System.out.println(result);
    }
}