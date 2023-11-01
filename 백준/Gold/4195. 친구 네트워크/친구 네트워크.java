import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parents;
	static int[] level;
	static LinkedList<String[]> list;
	static HashMap<String, Integer> hm;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine()); // 점의 개수
			
			int idx = 0;
			hm = new HashMap<>();
			list = new LinkedList<>();
			
			parents = new int[n*2];
			level = new int[n*2];
			Arrays.fill(level, 1);
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
//				list.add(new String[] {a, b});
				
				
				if(!hm.containsKey(a)) {
					parents[idx] = idx;
					hm.put(a, idx);
					idx++;
				}
								
				
				if(!hm.containsKey(b)) {
					parents[idx] = idx;
					hm.put(b, idx);
					idx++;	
				}
				
				union(hm.get(a), hm.get(b));
				
				sb.append(level[find(hm.get(b))]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		
		parents[a] = find(parents[a]);
		return parents[a];
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		level[aRoot] += level[bRoot];
		level[bRoot] = level[aRoot]; 
		return true;
	}
}