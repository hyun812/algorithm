import java.io.*;
import java.util.*;

public class Solution {
	static int n,m,k;
	static ArrayList<Bug> list;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스 개수
		int t = Integer.parseInt(bf.readLine());

		// 테스트 케이 개수 만큼 반복
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 셀의 개수
			m = Integer.parseInt(st.nextToken()); // 격리 시간
			k = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			
			list = new ArrayList<>();
			ans = 0;
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(bf.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				
				list.add(new Bug(i, y, x, cnt, dis));
			}
			
			for(int i=0; i<m; i++) {
				move();				
				checkBug();
			}
			
			for(int i=0; i<list.size(); i++) {
				ans += list.get(i).cnt;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void move() {
		for(int i=0; i<list.size(); i++) {
			Bug bug = list.get(i);
			
			bug.y = bug.y + dy[bug.dis];
			bug.x = bug.x + dx[bug.dis];
		}
	}
	
	private static void checkBug() {
		
		// 군집을 돌면서 약품이 칠해진 공간에 진입 시 미생물 수를 나누기 2
		// 군집이 겹쳤을 때 num을 같게 해주기
		for(Bug a : list) {
			if(!drugFillCheck(a.y, a.x)) {
				a.cnt = a.cnt/2;
				a.dis = reverseDis(a.dis);
			}
			
			for(Bug b : list) {
				if(a == b) continue;  // 같은 군집이면 continue
				if(a.y == b.y && a.x == b.x) {
					b.num = a.num;
				}
			}
		}
		
		// num 순으로 정렬
		// num이 같으면 cnt순으로 정렬
		Collections.sort(list);
		
		for(int i=0; i<list.size()-1; i++) {
			Bug a = list.get(i);
			Bug b = list.get(i+1);
			
			if(a.num == b.num) {
				a.cnt += b.cnt;
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
	private static boolean drugFillCheck(int y, int x) {
		if(y>0 && y<n-1 && x>0 && x<n-1) {
			return true;
		}
		return false;
	}
	
	static class Bug implements Comparable<Bug> {
		int num, y, x, cnt, dis;

		public Bug(int num, int y, int x, int cnt, int dis) {
			super();
			this.num = num;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "Bug [num=" + num + ", y=" + y + ", x=" + x + ", cnt=" + cnt + ", dis=" + dis + "]";
		}

		@Override
		public int compareTo(Bug o) {
			if(this.num != o.num) {
				return this.num - o.num;
			}else {
				return o.cnt - this.cnt;
			}
		} 
	}
}