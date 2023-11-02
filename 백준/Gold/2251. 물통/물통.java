import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] arr;
	static Set<Integer> set;
	static Queue<int[]> q;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		sb = new StringBuilder();
		arr = new int[3];
		set = new HashSet<>();
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i+" ");
		}
	}
	
	private static void bfs() {
		q = new LinkedList<>();
		visited = new boolean[201][201];
		
		q.add(new int[] {0, 0, arr[2]});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == 0) set.add(poll[2]);
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i==j) continue;
					move(poll, i, j);
				}
			}
		}
	}
	
	// from인덱스에 있는 물을 to인덱스에 있는 물통으로 보내기	
	private static void move(int[] poll, int from, int to) {
		int[] temp = poll.clone();
		
		int fWater = temp[from]; // from의 물 양
		int tWater = temp[to]; // to의 물 양
		
		int sum = fWater + tWater;
		if(arr[to] < sum) {
			temp[to] = arr[to];
			temp[from] -= arr[to]-tWater;  
		}else {
			temp[to] = sum;
			temp[from] = 0;	
		}
		
		if(visited[temp[0]][temp[1]]) return;
		
		
		q.add(new int[] {temp[0], temp[1], temp[2]});
		visited[temp[0]][temp[1]] = true;
	}
	
}