import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, c;
	static int[][] arr;
	static int[] nums;
	static int res;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 크기
			m = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
			c = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
			
			arr = new int[n][n];
			nums = new int[2];
			ans = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void comb(int start, int cnt) {
		if(cnt == 2) {
			// 선택한 벌통에서 최대 수익을 얻기위한 powerset
			
			int y1 = nums[0] / n;
			int x1 = nums[0] % n;
			int y2 = nums[1] / n;
			int x2 = nums[1] % n;
			
			if(x1 + m > n || x2 + m > n) return; // 가로로 범위 벗어나는지
			if(y1 == y2 && x1+m > x2) return; // 겹치는지
			
			ArrayList<Integer> l1 = new ArrayList<>();
			ArrayList<Integer> l2 = new ArrayList<>();
			
			for(int i=0; i<m; i++) {
				l1.add(arr[y1][x1+i]);
				l2.add(arr[y2][x2+i]);
			}
			
			res = 0;
			
			boolean[] checked1 = new boolean[m];
			powerset(0, 0, 0, l1, checked1);
			
			int temp = res;
			res = 0;
			boolean[] checked2 = new boolean[m];
			powerset(0, 0, 0, l2, checked2);
			
			ans = Math.max(ans, res+temp);
			
			return;
		}
		
		// 2차원 배열을 1차원 배열로
		for(int i=start; i<n*n-m+1; i++) {
			nums[cnt] = i;
			comb(i+1, cnt+1);
			
		}
	}
	
	
	private static void powerset(int cnt, int bee, int cal, ArrayList<Integer> l, boolean[] checked) {
		if(bee > c) return;
		
		if(cnt == m) {
			res = Math.max(res, cal);
			return;
		}
		
		checked[cnt] = true;
		powerset(cnt+1, bee+l.get(cnt), cal+(l.get(cnt)*l.get(cnt)),l, checked);
		checked[cnt] = false;
		powerset(cnt+1, bee, cal, l, checked);
	}
}