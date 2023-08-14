
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int white, blue;
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        check(0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    private static void check(int sr, int sc, int size) {
    	int sum = 0;
    	
    	for(int r= sr; r<sr+size; r++) {
			for(int c = sc; c<sc+size; c++) {
				sum += arr[r][c];
			}
		}
    	
    	if(sum == 0) {
    		white++;
    	}else if(sum == size*size) {
    		blue++;
    	}else {
    		int half = size/2;
    		check(sr, sc, half); // 1
    		check(sr, sc+half, half); // 2
    		check(sr+half, sc, half); // 3
    		check(sr+half, sc+half, half); // 4
    	}
    }
}


