

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int ans;
	static int[] row;
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(bf.readLine());
        
        row = new int[n+1];
        
        setQueen(1);
        
        System.out.println(ans);
    }
    
    private static void setQueen(int col) {
    	
    	if(!check(col-1)) {
    		return;
    	}
    	
    	
    	if(col > n) {
    		ans++;
    		return;
    	}
    	
    	
    	for(int i=1; i<=n; i++) {
    		row[col] = i;
    		setQueen(col+1);
    	}
    	
    }
    
    private static boolean check(int col) {
    	
    	for(int i=1; i<col; i++) {
    		if(row[col] == row[i] || col-i == Math.abs(row[col]-row[i])) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}


