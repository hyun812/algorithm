
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	String target = st.nextToken();
    	int[] arr = new int[26];
    	Arrays.fill(arr, -1);
    	
    	for(int i=0; i<target.length(); i++) {
    		int idx = target.charAt(i)-'0'-49;
    		if(arr[idx] == -1) {
    			arr[idx] = i;
    		}	
    	}
    	
    	
    	for(int i=0; i<26; i++) {
			System.out.print(arr[i] + " ");
    	}
    	
    	
    	
    	
    
    }
}