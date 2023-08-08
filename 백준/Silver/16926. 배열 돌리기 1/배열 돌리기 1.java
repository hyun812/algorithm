
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int line = Math.min(n, m)/2;
		
		for(int i=0; i<r; i++) { // 반복 횟수
			
			
			
			for(int j=0; j<line; j++) {
				
				int temp = arr[j][j];
				
				for(int k=j+1; k<m-j; k++) {
					 arr[j][k-1] = arr[j][k]; 
				}
				
				for(int k=j+1; k<n-j; k++) {
					 arr[k-1][m-j-1] = arr[k][m-j-1];
				}
				
				for(int k=m-2-j; k>=j; k--) {
					 arr[n-j-1][k+1] = arr[n-j-1][k]; 
				}
				
				for(int k=n-2-j; k>=j; k--) {
					 arr[k+1][j] = arr[k][j]; 
				}
				
				arr[j+1][j] = temp;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}