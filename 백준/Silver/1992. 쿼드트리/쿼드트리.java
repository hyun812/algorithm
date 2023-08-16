

import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        
        arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
        	String s = bf.readLine();
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(s.split("")[j]);
        	}
        }
        
        
        
        divide(0, 0, n);
        
        System.out.println(sb.toString());
    }
    
    private static void divide(int r, int c, int size) {
    	
    	int rsize = size/2;
    	
    	if(size < 1) return;
    	
    	int sum =0;
    	for(int i=r; i<r+size; i++) {
    		for(int j=c; j<c+size; j++) {
    			sum += arr[i][j]; 
    		}
    	}
    	
    	if(sum == 0) { // 다 흑백
    		sb.append(0);
    	}else if(sum == size*size) { // 다 흰색
    		sb.append(1);
    	}else { // 섞여있음
    		sb.append("(");
    		divide(r, c, rsize); // 왼쪽 위
    		divide(r, c+rsize, rsize); // 오른쪽 위
    		divide(r+rsize, c, rsize); // 왼쪽 아래
    		divide(r+rsize, c+rsize, rsize); // 오른쪽 아래
    		sb.append(")");
    	}
    	
    	
    	
    	
    }
}


