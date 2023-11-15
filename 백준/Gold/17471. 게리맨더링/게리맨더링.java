import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] person;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		visited = new boolean[n+1];
		person = new int[n+1]; // 각 구역의 인구수 저장
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=n; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(bf.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int to = Integer.parseInt(st.nextToken());
				// 양방향이므로
				list[i].add(to);
				list[to].add(i);
			}
		}
		ans = Integer.MAX_VALUE;
		powerset(1);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);	
		}
	}
	
	// 부분집합 ( 공징합이 아닌 )
	private static void powerset(int cnt) {
		if(cnt == n+1) {
			// 두 선거구로 나눔
			ArrayList<Integer> l1 = new ArrayList<>();
			ArrayList<Integer> l2 = new ArrayList<>();
			int size1 = 0;
			int size2 = 0;
			for(int i=1; i<=n; i++) {
				if(visited[i]) {
					l1.add(i);
					size1 += person[i];
				}else {
					l2.add(i);
					size2 += person[i];
				}
			}
			// 공집합이면 return
			if(l1.size() == 0 || l2.size() == 0) return;
			
			// 각각 선거구가 연결되어있는지 확인
			if(bfs(l1) && bfs(l2)) {
				ans = Math.min(ans, Math.abs(size2-size1));
			}
			return;
		}
		
		visited[cnt] = true;
		powerset(cnt+1);
		visited[cnt] = false;
		powerset(cnt+1);
	}
	
	private static boolean bfs(ArrayList<Integer> l) {
		// 전달받은 리스트의 원소값을 큐에 넣고
		// bfs 돌림
		// 갈 수 있는 곳 안에 포함되지 않는다면 못가는애임
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n+1];
		
		int start = l.get(0); 
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int i=0; i<list[poll].size(); i++) {
				int go = list[poll].get(i);
				
				if(visit[go]) continue;
				if(!l.contains(go)) continue;
				q.add(go);
				visit[go] = true;
			}
		}
		
		for(int i : l) {
			if(!visit[i]) {
				return false;
			}
		}
		
		return true;
		
	}
	
	// 인구의 차이를 최소로 하는 값
	
	
	
	
	
	
	
	
}