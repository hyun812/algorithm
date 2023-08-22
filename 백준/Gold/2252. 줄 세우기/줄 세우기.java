
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static ArrayList<Integer> ans = new ArrayList<>();
	static int[] inDegree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 사람수
		m = Integer.parseInt(st.nextToken()); // 비교 횟수
		
		inDegree = new int[n+1]; // 진입차수 관리 배열
		ArrayList<Integer>[] list = new ArrayList[n+1]; 
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
					
			inDegree[b]++;
			list[a].add(b);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			System.out.print(poll+" ");
			
			for(int i=0; i<list[poll].size(); i++) {
				int num = list[poll].get(i);
				inDegree[num]--;
					
				if(inDegree[num] == 0) {
					q.add(num);
				}
					
				
			}
			
			
		}
	}
	
	
}