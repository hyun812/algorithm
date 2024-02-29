import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		F = Integer.parseInt(st.nextToken()); // 전체
		S = Integer.parseInt(st.nextToken()); // 현재
		G = Integer.parseInt(st.nextToken()); // 목표
		U = Integer.parseInt(st.nextToken()); // 위로
		D = Integer.parseInt(st.nextToken()); // 아래로
		
		answer = -1;
		
		doit();
		
		if(answer == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(answer);	
		}
		
	}

	private static void doit() {

		boolean[] visited = new boolean[F + 2];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { S, 0 });

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			if (poll[0] == G) {
				answer = poll[1];
				return;
			}

			int up = poll[0] + U;
			int down = poll[0] - D;

			if (up <= F && !visited[up]) {
				q.add(new int[] { up, poll[1] + 1 });
				visited[up] = true;
			}

			if (down > 0 && !visited[down]) {
				q.add(new int[] { down, poll[1] + 1 });
				visited[down] = true;
			}

		}

	}
}