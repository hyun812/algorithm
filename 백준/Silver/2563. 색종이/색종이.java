
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	
    	boolean[][] arr = new boolean[100][100];
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(bf.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		for(int j=a; j<a+10; j++) {
    			for(int k=b; k<b+10; k++) {
    				arr[j][k] = true;
    			}
    		}
    	}
    	
    	int result = 0;
    	for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]) {
					result++;
				}
			}
		}
    	
    	System.out.println(result);
    	
    }
}