import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static String[][] arr;
	static int ans;
	
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine());
        arr = new String[n][n];
        
        for(int i=0; i<n; i++) {
        	String[] s = bf.readLine().split("");
        	for(int j=0; j<n; j++) {
        		arr[i][j] = s[j];
        	}
        }
        check();
        System.out.println(ans);
    }
        
    private static void check() {

    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n-1; j++) {
    			String a = arr[i][j];
    			String b = arr[i][j+1];
        		
        		int m = 0;
    			if(!a.equals(b)) {
    				arr[i][j] = b;
    				arr[i][j+1] = a;
    				m = getMax();
    				ans = Math.max(ans, m);
    				arr[i][j] = a;
    				arr[i][j+1] = b;
    			}
    		}
    		
    		for(int j=0; j<n-1; j++) {
    			String c = arr[j][i];
    			String d = arr[j+1][i];

        		int m = 0;
    			if(!c.equals(d)) {
    				arr[j][i] = d;
    				arr[j+1][i] = c;
    				m = getMax();
    				ans = Math.max(ans, m);
    				arr[j][i] = c;
    				arr[j+1][i] = d;
    			}
    		}
    	}
    }
    
    private static int getMax() {
    	int max = 0;
    	
    	for(int i=0; i<n; i++) {
    		int cnt1 = 1;
    		for(int j=0; j<n-1; j++) {
    			if(arr[i][j].equals(arr[i][j+1]))
    				cnt1++;
    			else {
    				max = Math.max(max, cnt1);
    				cnt1 =1;
    				if(max == n) return max;
    				
    			}
    			max = Math.max(max, cnt1);    			
    		}
    		
    		int cnt2 = 1;
    		for(int j=0; j<n-1; j++) {
    			if(arr[j][i].equals(arr[j+1][i])) cnt2++;
    			else {
    				max = Math.max(max, cnt2);
    				if(max == n) return max;
    				cnt2 = 1;
    			}
    			max = Math.max(max, cnt2);    			
    		}
    	}
    	
    	return max;
    }
}