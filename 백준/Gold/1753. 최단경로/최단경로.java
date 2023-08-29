import java.util.*;
import java.io.*;

public class Main {
	static int v, e, start;
	static ArrayList<List<Vertex>> list;
	static int[] mind;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(bf.readLine());
		
		list = new ArrayList<>();
		for(int i=0; i<=v; i++) {
			list.add(new ArrayList<Vertex>());
		}
		
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Vertex(v, w));
		}
		
		mind = new int[v+1];
		visited = new boolean[v+1];
		int minVertex = 0;
		int minWeight = 0;
		int cnt = 0;
		
		Arrays.fill(mind, Integer.MAX_VALUE);
		Queue<Vertex> pq = new PriorityQueue<>((o1, o2) -> (o1.weight > o2.weight ? 1 : (o1.weight == o2.weight ? 0 : -1)));
		pq.offer(new Vertex(start,0));
		mind[start] = 0;
		
		while(!pq.isEmpty()) {
			Vertex poll = pq.poll();
			minVertex = poll.no;
			minWeight = poll.weight;
			
			if(visited[minVertex]) continue;
			
			visited[minVertex] = true;
			cnt++;
			
			if(cnt == v) break;
			
			for(Vertex vertex : list.get(minVertex)) {
				if(!visited[vertex.no] && vertex.weight+minWeight < mind[vertex.no]) {
					mind[vertex.no] = vertex.weight+minWeight;
					pq.offer(new Vertex(vertex.no, mind[vertex.no]));
				}
			}
		}
		
		for(int i=1; i<=v; i++) {
			if(mind[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(mind[i]);
		}
	}
}

class Vertex {
	int no;
	int weight;
	
	public Vertex(int no, int weight) {
		super();
		this.no = no;
		this.weight = weight;
	}
}
