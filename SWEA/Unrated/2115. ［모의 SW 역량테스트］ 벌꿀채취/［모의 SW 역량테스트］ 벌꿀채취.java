import java.io.*;
import java.util.*;

public class Solution {
	static int n,m,c;
	static int[][] arr;
	static boolean[] visited;
	static ArrayList<int[]> list;
	static int fmax,smax, fcnt, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int t = Integer.parseInt(bf.readLine());
		
		// 테스트 케이스 만큼 반복
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 벌통 크기 (배열 크기)
			m = Integer.parseInt(st.nextToken()); // 벌통의 개수
			c = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대의 양
			
			arr = new int[n][n];
			visited = new boolean[n*n];
			list = new ArrayList<>();
			ans = Integer.MIN_VALUE;
			
			// 입력 받기
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			select(0, 0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	// 벌통 M개 묶음 2개 선택 (조합) 
	private static void select(int start, int cnt) {
		if(cnt == 2) {
			int[] f = list.get(0);
			int[] s = list.get(1);
			
			// 같은줄에 있으면서 겹치면 return
			if(f[0] == s[0] && f[1]+m > s[1]) return;
			
			// 선택한 벌통에 있는 꿀의 양을 저장할 배열
			int[] fArr = new int[m];
			int[] sArr = new int[m];
			for(int i=0; i<m; i++) {
				fArr[i] = arr[f[0]][f[1]+i];
				sArr[i] = arr[s[0]][s[1]+i];
			}
			boolean[] fv = new boolean[m];
			boolean[] sv = new boolean[m];
			fcnt = 0; // powerset 각각의 최대값을 구하기 위한 변수
			fmax = smax = Integer.MIN_VALUE;
			
			powerSet(0,fArr,fv,0);
			fcnt++;
			powerSet(0,sArr,sv,0);
			
			ans = Math.max(ans, fmax+smax);
			return;
		}
		
		// 2차월 배열 > 1차원 배열로
		for(int i=start; i<n*n; i++) {
			int y = i/n;
			int x = i%n;

			// 같은 줄에 있어야함 + 배열의 범위 벗어나면 x			
			if(x+m > n) continue;
			list.add(cnt, new int[] {y, x});
			select(i+1, cnt+1);
		}
	}
	// 1개의 벌통에서 부분집합으로 꿀 확인
	private static void powerSet(int cnt, int[] ar, boolean[] vi, int sum) {
		if(sum > c) return; // 이미 채취할 수 있는 최대양을 넘었으면 return		
		
		if(cnt == m) {
			int cal = 0;
			for(int i=0; i<m; i++) {
				if(!vi[i]) continue;
				cal += (ar[i]*ar[i]);
			}
			
			if(fcnt == 0) {
				fmax = Math.max(fmax, cal);
			}else {
				smax = Math.max(smax, cal);
			}
			
			return;
		}
		
		vi[cnt] = true;
		powerSet(cnt+1, ar, vi, sum+ar[cnt]);
		vi[cnt] = false;
		powerSet(cnt+1, ar, vi, sum);
		
	}
	
	// 부분 집합 뽑은 애들 제곱수 확인
}