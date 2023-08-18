import java.io.*;
import java.util.*;

// bfs
public class Main {
    // static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] list;
	static int[] dis;
	static int[] target;
	static int ans = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        target = new int[2];
		st = new StringTokenizer(bf.readLine());
		target[0] = Integer.parseInt(st.nextToken());
		target[1] = Integer.parseInt(st.nextToken());

		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList();
		}

		dis = new int[n+1];

		int m = Integer.parseInt(bf.readLine()); // 부모자식들 간의 관계 개수
		for(int i=0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		bfs();
		System.out.println(ans);
    }

	private static void bfs(){
		Queue<Integer> q = new LinkedList<>();
		int start = target[0];
		q.add(start);
		dis[start] = 0;
		

		while(!q.isEmpty()){
			int poll = q.poll();

			if(poll == target[1]){
				ans = dis[poll];
				return;
			}
			
			for(Integer i : list[poll]){
				if(dis[i] == 0){
					q.add(i);
					dis[i] = dis[poll]+1;
				}
			}
		}
	}




}
         