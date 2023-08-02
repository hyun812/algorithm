
import java.util.*;
import java.io.*;

class Solution
{
	static int score;
	static int[] taste;
	static int[] cal;
	static int L;
	public static void main(String[] args) throws Exception  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = 0;
			
			taste = new int[N];
			cal = new int[N];
			boolean[] include = new boolean[N];
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(bf.readLine());
				taste[j] = Integer.parseInt(st.nextToken());
				cal[j] = Integer.parseInt(st.nextToken());
			}
			powerset(include, 0, N);
			
			System.out.println("#" + i + " " + score);
		}
	}
	
	public static void powerset(boolean[] include, int k, int n) {
		if(n == k) {
			int sumtaste = 0;
			int sumCal = 0;
			
			for(int i=0; i<n; i++) {
				if(include[i]) {
					sumtaste += taste[i];
	            	sumCal += cal[i];
				}
			}
			if(sumCal <= L && score < sumtaste) score = sumtaste;
			return;
		}
		include[k] = false;
		powerset(include, k+1, n);
		include[k] = true;
		powerset(include, k+1, n);
	}
}