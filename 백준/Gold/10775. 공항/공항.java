import java.io.*;
import java.util.*;

public class Main {
	static int G, P;
	static int[] parent;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		G = Integer.parseInt(bf.readLine());
		P = Integer.parseInt(bf.readLine());

		parent = new int[G + 1];
		for (int i = 0; i <= G; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < P; i++) {
			int n = Integer.parseInt(bf.readLine());

			int parentNum = find(n);

			if (parentNum == 0)
				break;
			union(parentNum, parentNum - 1);
			answer++;
		}

		System.out.println(answer);
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		parent[pa] = pb;
	}
}