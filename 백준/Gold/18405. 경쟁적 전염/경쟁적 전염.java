import java.io.*;
import java.util.*;

public class Main {
	static int n, k, time;
	static int[][] arr;
	static Queue<virus> q;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		q = new ArrayDeque<>();
		ArrayList<virus> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    list.add(new virus(i, j, 0, arr[i][j]));
                }
            }
        }

        Collections.sort(list, new Comparator<virus>() {
            @Override
            public int compare(virus o1, virus o2) {
                return o1.size - o2.size;
            }
        });

        for (virus v : list) {
            q.add(v);
        }
        
		st = new StringTokenizer(bf.readLine());
		time = Integer.parseInt(st.nextToken());
		int rY = Integer.parseInt(st.nextToken())-1;
		int rX = Integer.parseInt(st.nextToken())-1;
		bfs();
		
		System.out.println(arr[rY][rX]);
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static void bfs() {
		while(!q.isEmpty()) {
			virus v = q.poll();
			int y = v.y;
			int x = v.x;
			if(v.time == time) return;
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(arr[ny][nx] != 0) continue;
				
				arr[ny][nx] = v.size;
				q.add(new virus(ny, nx, v.time+1, v.size));
//				for(int j=0; j<n; j++) {
//					System.out.println(Arrays.toString(arr[j]));
//				}
//				System.out.println();
				
				
				
			}
		}
		
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
	
	
	static class virus{
		int y, x, time, size;

		public virus(int y, int x, int time, int size) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
			this.size = size;
		}

	}
}