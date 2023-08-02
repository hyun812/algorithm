
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String s = bf.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(s.split("")[j]);	
				}
			}
			
			int sum = value(arr , n);
			System.out.println("#"+tc+" "+sum);
			
		}
		
		
	}
	
	public static int value(int[][] arr, int n) {
		int center = n/2; // 2
		int sumV = arr[0][center];
		int cnt = 1;
		
		for(int i=1; i<=n/2; i++) {
			for(int j=center-cnt; j<=center+cnt; j++) {
				sumV += arr[i][j];
			}
			cnt++;
		}
		
		cnt-= 2;
		for(int i=(n/2)+1; i<n; i++) {
			for(int j=center-cnt; j<=center+cnt; j++) {
				sumV += arr[i][j];
			}
			cnt--;
		}
		
		return sumV;
	}
}

//1
//5
//14054
//44250
//02032
//51204
//52212







