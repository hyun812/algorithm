import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static String[] arr;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 단어의 개수
		k = Integer.parseInt(st.nextToken()); // 가르칠 수 있는 글자의 수

		arr = new String[n];
		visited = new boolean[26];
		answer = Integer.MIN_VALUE;
		// a, n, t, i, c
		for (int i = 0; i < n; i++) { // 필요한 단어의 개수를 셈
			String s = bf.readLine();
			s = s.replace("anta", "");
			s = s.replace("tica", "");
			arr[i] = s;
		}

		if (k < 5) {
			System.out.println("0");
			return;
		} else if (k == 26) {
			System.out.println(n);
			return;
		}

		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;

		check(0, 0);
		
		System.out.println(answer);
	}

	// 26개 중 순서 상관업이 뽑기
	private static void check(int idx, int len) {
		if (len == k - 5) {
			int count = 0;

			for (int i = 0; i < n; i++) {
				boolean flag = true;
				String target = arr[i];
				for (int j = 0; j < target.length(); j++) {
					if (!visited[target.charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag)
					count++;
			}

			answer = Math.max(answer, count);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			check(i, len + 1);
			visited[i] = false;
		}
	}

}