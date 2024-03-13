import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] Aarr, Barr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		Aarr = new int[n];
		Barr = new int[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			Aarr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Aarr);

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			Barr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Barr);

		answer = 0;
		for (int i = 0; i < n; i++) {
			answer += Aarr[i] * Barr[n -1 - i];
		}

		System.out.println(answer);

	}
}