import java.io.*;
import java.util.*;

public class Main {
	static int s;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		s = Integer.parseInt(bf.readLine());

		// 1개 0 초
		// 2개 >> 1개복사 > 붙혀넣기 >> 2초
		// 3개 >> 1개복사 > 붙혀넣기 >> 2개복사 > 붙혀넣기
		// 4개 >> 1개복사 >> 붙혀넣기 >> 2개복사

		bfs();

	}

	private static void bfs() {
		Queue<Imo> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[2001][2001];// 스크린, 클립
		q.add(new Imo(1, 0, 0));
		
		while (!q.isEmpty()) {
			Imo poll = q.poll();

			int screen = poll.screen;
			int clip = poll.clip;
			int time = poll.time;

			if (screen == s) {
				System.out.println(time);
				return;
			}

			if (screen > 0 && screen < 2000) {
				// 복사
				if (!visited[screen][screen]) {
					visited[screen][screen] = true;
					q.add(new Imo(screen, screen, time + 1));
				}

				// 삭제
				if (!visited[screen - 1][clip]) {
					visited[screen - 1][clip] = true;
					q.add(new Imo(screen - 1, clip, time + 1));
				}
			}

			if (clip > 0 && screen + clip < 2000) {
				if (visited[screen + clip][clip])
					continue;
				visited[screen + clip][clip] = true;
				q.add(new Imo(screen + clip, clip, time + 1));
			}
		}
	}

	static class Imo {
		int screen, clip, time;

		public Imo(int screen, int clip, int time) {
			super();
			this.screen = screen;
			this.clip = clip;
			this.time = time;
		}
	}
}