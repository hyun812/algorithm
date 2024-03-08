import java.io.*;
import java.util.*;

public class Main {
	static int na, nb;
	static HashMap<Integer, Integer> Ahm;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		na = Integer.parseInt(st.nextToken());
		nb = Integer.parseInt(st.nextToken());

		Ahm = new HashMap<>();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < na; i++) {
			Ahm.put(Integer.parseInt(st.nextToken()), 0);
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < nb; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (Ahm.containsKey(target)) {
				Ahm.remove(target);
			}
		}

		sb.append(Ahm.size()).append("\n");
		List<Integer> keySet = new ArrayList<>(Ahm.keySet());

		// 키 값으로 오름차순 정렬
		Collections.sort(keySet);

		for (Integer key : keySet) {
			sb.append(key).append(" ");
		}

		System.out.println(sb.toString());

	}
}