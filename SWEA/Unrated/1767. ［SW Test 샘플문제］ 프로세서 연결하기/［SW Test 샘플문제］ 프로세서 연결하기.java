import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static ArrayList<int[]> list;
	static int ans;
	static int maxCount;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t=  Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine());
			
			arr = new int[n][n];
			list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						if(i==0 || j==0 || i==n-1 || j==n-1) continue;
						list.add(new int[] {i, j});
					}
				}
			}
			
			visited = new boolean[list.size()];
			maxCount = Integer.MIN_VALUE;
			ans = Integer.MAX_VALUE;
			
			powerset(0, 0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void powerset(int cnt, int count) {
		
		if(cnt == list.size()) {
			if(maxCount < count) {
				maxCount = count;
				
				int temp = 0;
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(arr[i][j] != 2) continue;
						temp++;
					}
				}
				ans = temp;
			}else if(maxCount == count) {
				int temp = 0;
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(arr[i][j] != 2) continue;
						temp++;
					}
				}
				ans = Math.min(ans, temp);
			}
			
			return;
		}
		
		// 4방향 중 어디로 연결할 지
		for(int j=0; j<4; j++) {
			// 해당방향으로 연결할 수 있는지 확인
			if(!isConnect(cnt, j)) continue;
				
			// 연결하기
			connect(cnt, j, 2);
			visited[cnt] = true;
			powerset(cnt+1, count+1);
			connect(cnt, j, 0);
			visited[cnt] = false;
		}
		powerset(cnt+1, count);		
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	// 연결 할 수 있는지 판단
	private static boolean isConnect(int idx, int dis) {
		int[] target = list.get(idx);
		int y = target[0];
		int x = target[1];
		
		
		int ny = y;
		int nx = x;
		while(true) {
			ny += dy[dis];
			nx += dx[dis];
			
			if(!outOfIdx(ny, nx)) break;
			if(arr[ny][nx] == 1 || arr[ny][nx] == 2) return false;
		}
		
		return true;
	}
	
	private static void connect(int idx, int dis, int value) {
		int[] target = list.get(idx);
		int y = target[0];
		int x = target[1];
		
		
		int ny = y;
		int nx = x;
		while(true) {
			ny += dy[dis];
			nx += dx[dis];
			
			if(!outOfIdx(ny, nx)) break;
			arr[ny][nx] = value;
		}
		return;
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
	
	
	
}