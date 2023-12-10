import java.io.*;
import java.util.*;

public class Main {
	static int n, c;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 집의 개수
		c = Integer.parseInt(st.nextToken()); // 공유기의 개수

		arr = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			max = Math.max(max, arr[i]);
		}
		Arrays.sort(arr);

		int min = 0;
		int mid = 0; // 공유기 사이의 최소 거리

		while (min <= max) {
			mid = (min + max) / 2;

			if (solution(mid) < c) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println((min+max)/2);
	}

	// 공유기 사이의 거리를 기준으로 몇개의 공유기를 설치할 수 있는지를 반환
	private static int solution(int mid) {
		// 1 2 4 8 9
		int count = 1; // 처음 집에는 반드시 공유기가 깔려있다고 가정
		int temp = arr[0];

		for (int i = 1; i < n; i++) {
			int target = arr[i];
			if (target-temp >= mid) {
				count++;
				temp = target;
			}
		}
		return count;
	}
}