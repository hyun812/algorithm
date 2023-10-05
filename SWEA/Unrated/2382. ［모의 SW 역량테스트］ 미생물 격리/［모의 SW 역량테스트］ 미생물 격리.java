import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, k;
	static ArrayList<mic> list;
	static int ans;
	static int[] dy = {0, -1, 1, 0, 0}; // 0  상 하 좌 우
	static int[] dx = {0, 0, 0, -1, 1}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 세로 n, 가로 n
			m = Integer.parseInt(st.nextToken()); // 시간
			k = Integer.parseInt(st.nextToken()); // k개의 미생물
			
			ans = 0;
			list = new ArrayList<>(); // 군집들을 담을 list
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(bf.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				
				list.add(new mic(i, y, x, cnt, dis));
			}
			move();
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	// List에 군집들 다 넣기
	// 이동 다 시키기
	// 이동 후 판단하기 > 
	//	1. 약품이 칠해진 칸에 도착하면 방향 반대로 + 미생물 수 /2 해주기
	// 	2. 군집이 합쳐졌을 때 미생물 수 합침 + 방향은 미생물이 많은 군집 따라감
	//  List에 담은 군집들을 정렬시킴 (num, cnt)
	
	private static void move() {
		for(int i=0; i<m; i++) { // 시간만큼 반복
			
			for(int j=0; j<list.size(); j++) {
				mic m = list.get(j);
				m.y = m.y+dy[m.dis];
				m.x = m.x+dx[m.dis];
			}
			
			check();
		}
		
		for(int i=0; i<list.size(); i++) {
			ans += list.get(i).cnt;
		}
	}

	private static void check() {
		// 정렬
		for(mic m1 : list) {
			if(divide(m1.y, m1.x)) {
				m1.cnt = m1.cnt/2;
				m1.dis = reverseDis(m1.dis);
			}
			
			
			for(mic m2 : list) {
				if(m1 == m2) continue;
				if(m1.y == m2.y && m1.x == m2.x) {
					m2.num = m1.num;
				}
			}
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size()-1; i++) {
			mic m1 = list.get(i);
			mic m2 = list.get(i+1);
			
			if(m1.num == m2.num) {
				m1.cnt += m2.cnt;
				list.remove(i+1);
				i--;
			}
		}
	}
	
	private static int reverseDis(int dis) {
		int d = 0;
		switch (dis) {
		case 1:
			d = 2;
			break;
		case 2:
			d = 1;
			break;
		case 3:
			d = 4;
			break;
		case 4:
			d = 3;
			break;
		}
		return d;
	}
	
	private static boolean divide(int y, int x) { // true면 약품이 칠해진 칸에 도착
		if(y>0 && y<n-1 && x>0 && x<n-1) {
			return false;
		}
		return true;
	}
	
	static class mic implements Comparable<mic>{
		int num, y, x, cnt, dis;

		public mic(int num, int y, int x, int cnt, int dis) {
			super();
			this.num = num;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dis = dis;
		}

		@Override
		public int compareTo(mic o) { // num으로 정렬,  같으면 cnt로 정렬
			if(this.num == o.num) {
				return o.cnt-this.cnt;
			}
			return this.num-o.num;
		}

		@Override
		public String toString() {
			return "mic [num=" + num + ", y=" + y + ", x=" + x + ", cnt=" + cnt + ", dis=" + dis + "]";
		}
	}
}