
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(bf.readLine()); // 회전 횟수
			arr = new int[5][8];

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// n극은 0 , s극은 1
				}
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(bf.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				int[] directions = getDirections(num, dir);
				
				for(int j=1; j<=4; j++) {
					if(directions[j] != 0) {
						rotate(j, directions[j]);		
					}
				}
			}
			
			int ans = 0;
			int score =1;
			for (int i = 1; i <= 4; i++) {
				if(arr[i][0] == 1) {
					ans += score;
				}
				score *= 2;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] getDirections(int num, int dir) {
		// 회전x : 0 시계 방향 : -1 , 반시계방향 : 1
		int[] directions = new int[5];
		directions[num] = dir;
		
		// 왼쪽방향
		for (int i = num; i > 1; i--) {
			if (arr[i][6] == arr[i - 1][2])
				break;

			directions[i - 1] = directions[i] * -1;
		}
		// 오른쪽방향
		for (int i = num; i < 4; i++) {
			if (arr[i][2] == arr[i + 1][6])
				break;

			directions[i + 1] = directions[i] * -1;
		}
		
		return directions;
	}

	private static void rotate(int n , int dir) {
		if (dir == 1) { // 시계
			int temp = arr[n][7];
			for (int i = 6; i >= 0; i--)
				arr[n][i + 1] = arr[n][i];
			arr[n][0] = temp;
			
		} else if (dir == -1) { // 반시계
			
			int temp = arr[n][0];
			for (int i = 0; i <= 6; i++)
				arr[n][i] = arr[n][i + 1];
			arr[n][7] = temp;
			
		}
	}
}