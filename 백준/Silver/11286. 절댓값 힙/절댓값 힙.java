
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		int n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());
			int abs = Math.abs(num);
			if (num == 0) {

				if (heap.size() != 0) {
					sb.append(heap.poll()[1]).append("\n");
				} else {
					sb.append("0").append("\n");
				}

			} else {
				heap.add(new int[] { abs, num });
			}

		}

		System.out.println(sb.toString());

	}
}
