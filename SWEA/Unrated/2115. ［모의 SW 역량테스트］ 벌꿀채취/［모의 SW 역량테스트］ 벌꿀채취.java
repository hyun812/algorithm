import java.io.*;
import java.util.*;

public class Solution {
	static int[][] arr;
	static int[] selected;
	static int n,m,c;
	static int ans;

	static boolean[] visited;
	static int count = 1;
	static int max1, max2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 벌통들의 크기
			m = Integer.parseInt(st.nextToken()); // 벌통의 개수
			c = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
			
			ans = Integer.MIN_VALUE;
			
			arr = new int[n][n];
			selected = new int[2];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0, 0);
			
			System.out.println("#"+tc+" "+ ans);
		}
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == 2) { // 2개 뽑으면
			// 2개뽑은게 서로 겹치면 return
			int one = selected[0];
			int two = selected[1];
			
			if(one/n == two/n && one%n+m > two%n) { // 같으 줄에 있으면서 
				return;
			}
			
			count = 1;
			max1 = Integer.MIN_VALUE;
			max2 = Integer.MIN_VALUE;
			int[] num1 = new int[m];
			int[] num2 = new int[m];

			for(int i=0; i<m; i++) {
				num1[i] = arr[one/n][one%n+i];
			}
			for(int i=0; i<m; i++) {
				num2[i] = arr[two/n][two%n+i];
			}
			
			powerSet(num1, 0, 0, 0);
			count++;
			powerSet(num2, 0, 0, 0);
			
			ans = Math.max(max1+max2, ans);
			return;
		}
		
		for(int i=start; i<n*n; i++) {
			if(i%n > n-m) continue;
			selected[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	private static void powerSet(int[] nArr, int cnt, int sum, int cal) {
		if(cnt == m) {
			if(sum > c || sum == 0) return;
			
			if(count== 1) {
				max1 = Math.max(cal, max1);
			}else {
				max2 = Math.max(cal, max2);
			}
			
			return;
		}
		
		int num = nArr[cnt];
		powerSet(nArr, cnt+1, sum+num, cal+(num*num));
		powerSet(nArr, cnt+1, sum, cal);
		
	}
}
