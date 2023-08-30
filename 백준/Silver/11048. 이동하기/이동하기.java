import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			arr[i][0] += arr[i-1][0]; 
		}
		for(int i=1; i<m; i++) {
			arr[0][i] += arr[0][i-1]; 
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1])+arr[i][j];
			}
		}
		
		System.out.println(arr[n-1][m-1]);
		
	}
	
}

