import java.io.*;
import java.util.*;

public class Main {
	static String s;
	static int answer;
	static int[] alpa;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		s = bf.readLine();

		alpa = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char target = s.charAt(i);
			alpa[target - 'a']++;
		}

		doit(0, "");
		
		System.out.println(answer);
	}

	private static void doit(int len, String temp) {
		if (len == s.length()) {
			answer++;
			return;
		}

		for (int i = 0; i < alpa.length; i++) {
			if (alpa[i] == 0)
				continue;

			String target = temp + (char) (i + 'a');
			if (!"".equals(temp) && temp.charAt(temp.length() - 1) == (char) (i + 'a')) {
				continue;
			}
			alpa[i]--;
			doit(len + 1, target);
			alpa[i]++;
		}
	}
}