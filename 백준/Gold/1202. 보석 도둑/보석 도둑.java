import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] kArr;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 보석점에 있는 보석 개수
		k = Integer.parseInt(st.nextToken()); // 가지고 있는 가방 개수

		kArr = new int[k]; // 각 가방에 담을 수 있는 최대 무게

		ArrayList<jewel> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.add(new jewel(m, v));
		}
		// 무게 오름차순 정렬
		Collections.sort(list, (o1, o2) -> o1.m - o2.m);

		for (int i = 0; i < k; i++) {
			kArr[i] = Integer.parseInt(bf.readLine());
		}
		// 가방 오름차순 정렬
		Arrays.sort(kArr);

		// 가격 내림차순
		Queue<jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);

		int idx = 0;
		
		// 가방 한개씩 확인 ( 무게가 낮은 것 부터 ) 
		for (int i = 0; i < k; i++) {
			
			// 가방에 넣을 수 있으면
			while (idx < n && list.get(idx).m <= kArr[i]) {
				jewel g = list.get(idx++);
				pq.add(g);
			}

			if (!pq.isEmpty())
				answer += pq.poll().v;
		}

		// 훔칠 수 있는 보석 가격 합의 최대값
		System.out.println(answer);

	}

	static class jewel {
		int m;
		int v;

		public jewel(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}
	}
}