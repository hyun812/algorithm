import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr;
	static boolean[] robot;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		answer = 0;

		arr = new int[2 * n];
		robot = new boolean[n]; // 로봇은 1~n까지만 존재함

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		doit();

		System.out.println(answer);
	}
	// 로봇이 내리는 위치에 오면 즉시 내림
	// 이동하려면 그곳에 로봇이 없고 내구도가 1이상 남아있어야 함

	// 로봇은 1에서 N까지만 존재
	private static void doit() {

		while (true) {
			answer++;
			// 컨베이어 벨트 이동
			int temp = arr[arr.length - 1];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;

			for (int i = robot.length - 1; i > 0; i--) { // 로봇도 벨트와 같이 회전
				robot[i] = robot[i - 1];
			}
			robot[0] = false;
			robot[n - 1] = false; // 마지막이면 떨구기
			
			// 로봇 이동
			for (int i = n - 1; i > 0; i--) { 
				if (robot[i - 1] && !robot[i] && arr[i] > 0) {
					robot[i] = true;
					robot[i - 1] = false;
					arr[i]--;
				}
			}
			robot[n - 1] = false; // 마지막이면 떨구기
			
			// 로봇올리기
			if (arr[0] > 0) {
				robot[0] = true;
				arr[0]--;
			}
			// 0인 칸의 개수 세기
			int count = 0;
			for (int i = 0; i < 2 * n; i++) {
				if (arr[i] == 0) {
					count++;
				}
			}

			if (count >= k) {
				return;
			}

		}

	}

}