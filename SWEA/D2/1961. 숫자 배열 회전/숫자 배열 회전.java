import java.io.*;
import java.util.*;

public class Solution {
	static String[][] result;
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
				 
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			
			for(int j=0; j<n; j++){
		    	st = new StringTokenizer(bf.readLine());
		    	for(int k=0; k<n; k++) {
		    		arr[j][k] =Integer.parseInt(st.nextToken());
		    	}
	        }

		    fn(arr);
			System.out.println("#"+(i+1));
			for(int a=0; a<n; a++){
				for(int b=0; b<3; b++){
					System.out.print(result[a][b] + " ");
				}
				System.out.println("");
			}
			
		}
	}	
	public static void fn(int[][] arr) {
		int n= arr.length;
		result = new String[n][3];

		for(int i=0; i<n; i++){
			result[i][0] = "";
			for(int j=0; j<n; j++){
				result[i][0] += arr[n-j-1][i];
			}	
		}

		for(int i=0; i<n; i++){
			result[i][1] = "";
			for(int j=0; j<n; j++){
				result[i][1] += arr[n-i-1][n-j-1];
			}	
		}

		for(int i=0; i<n; i++){
			result[i][2] = "";
			for(int j=0; j<n; j++){
				result[i][2] += arr[j][n-i-1];
			}	
		}
	}
}
