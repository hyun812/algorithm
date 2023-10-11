import java.io.*;
import java.util.*;

public class Solution {
	static int d, w, k;
	static int[][] arr;
	static int[] fill;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스 개수
		int t = Integer.parseInt(bf.readLine());

		// 테스트 케이스 만큼 반복
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			arr = new int[d][w];
			ans = Integer.MAX_VALUE;
			// 입력받기
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 0이면 A 1이면 B
				}
			}

			fill = new int[d];
			Arrays.fill(fill, -1);
			
			powerset(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	// 부분집합
	private static void powerset(int idx, int cnt) {
		if(cnt > ans) {
			return;
		}
		
		if (idx == d) {
			int[][] copy = new int[d][w];
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					copy[i][j] = arr[i][j];
				}
			}
			
			fillMed(copy);
			if(checkCol(copy)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}

		// 안 채우기
		fill[idx] = -1;
		powerset(idx + 1, cnt);

		// 0으로 채우기 (A)
		fill[idx] = 0;
		powerset(idx + 1, cnt + 1);

		// 1로 채우기 (B)
		fill[idx] = 1;
		powerset(idx + 1, cnt + 1);

	}

	// 해당 라인 약품 집어넣기
	private static void fillMed(int[][] copy) {
		for(int i=0; i<d; i++) {
			if(fill[i] == -1) continue;
				for(int j=0; j<w; j++) {				
					copy[i][j] = fill[i];
				}
		}
	}

	// 세로방향으로 확인하면서 k개 이상 연속적으로 있는지 확인
	private static boolean checkCol(int[][] copy) {

		for (int i = 0; i < w; i++) {
			int cnt = 1; // 연속하는 개수를 세기 위한 변수
			int cur = copy[0][i]; // 최근 사용한 셀을 담을 변수
			for (int j = 1; j < d; j++) {
				if (cnt >= k) // 다음 세로줄로 이동
					break;
				if (copy[j][i] == cur) { // 최근 사용한 것과 같으면 cnt 증가
					cnt++;

				} else { // 다르다면 초기화
					cur = copy[j][i];
					cnt = 1;
				}
			}
			if (cnt < k)
				return false;
		}

		return true;
	}
	
	private static void print(int[][] copy) {
		for(int i=0; i<d; i++) {
			System.out.println(Arrays.toString(copy[i]));
		}
		System.out.println();
	}
}