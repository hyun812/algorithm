import java.io.*;
import java.util.*;

public class Main {
	static long a, b;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		answer  = Integer.MAX_VALUE;
		dfs(a, 1);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(answer);	
		}
		
	}

	private static void dfs(long n, int cnt) {
		if(cnt >= answer) return;
		if(n > b) return;
		if (n == b) {
			answer = cnt;
			return;
		}
		String s = Long.toString(n) + 1;

		dfs(n * 2, cnt + 1);
		dfs(Long.parseLong(s), cnt + 1);
	}
}