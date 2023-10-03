import java.io.*;
import java.util.*;

public class Solution {
	static int m, a;
	static int[] aPos, bPos; // a와 b의 이동 방향 저장할 배열
	static int[] dy = {0, 0, 1, 0, -1}; // 상 우 하 좌
	static int[] dx = {0, -1, 0, 1, 0}; // 상 우 하 좌
	static ArrayList<apinfo> list; // 배터리 정보를 저장할 리스트
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			ans = 0;
			aPos = new int[m];
			bPos = new int[m];
			list = new ArrayList<>();
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<m; i++) {
				aPos[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<m; i++) {
				bPos[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<a; i++) {
				st = new StringTokenizer(bf.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cover = Integer.parseInt(st.nextToken());
				int perfor = Integer.parseInt(st.nextToken());
				
				list.add(new apinfo(y, x, cover, perfor));
			}
			
			move();
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	// a와 b 둘다 한칸씩 옮긴 뒤에 계산하기
	// 같은 충전 범위에 들어온다면 체크해야하는데
	// 둘다 충전범위 하나에만 들어와 있다면 균등하게 배분
	// 2개이상의 충전범위에 들어와 있다면 계산해서 배분
	private static void move() { // 이동할 함수
		 
		int[] axy = new int[] {1, 1}; // a와 b의 포지션
		int[] bxy = new int[] {10, 10};
		
		check(axy, bxy); // 초기상태에서 확인
		
		for(int i=0; i<m; i++) { // m만큼 반복
			
			// 좌표 이동
			axy[0] = axy[0]+dy[aPos[i]];
			axy[1] = axy[1]+dx[aPos[i]];
			
			bxy[0] = bxy[0]+dy[bPos[i]];
			bxy[1] = bxy[1]+dx[bPos[i]];
			
			check(axy, bxy);
		}
	}
	
	private static void check(int[] axy, int[] bxy) { // 현재 좌표 기반 최적 배터리 선택하는 함수
		ArrayList<Integer> am = new ArrayList<>();
		ArrayList<Integer> bm = new ArrayList<>();
		for(int i=0; i<a; i++) { // 배터리 수만큼 반복
			apinfo ai = list.get(i);
			// 범위 확인해서 리스트에 추가
			if(Math.abs(ai.y - axy[0])+Math.abs(ai.x - axy[1]) <= ai.cover) {
				am.add(i);
			}
			
			if(Math.abs(ai.y - bxy[0])+Math.abs(ai.x - bxy[1]) <= ai.cover) {
				bm.add(i);
			}
		}
		int max =0;
		if(am.size() > 0 && bm.size() > 0) { // 둘다 1개 이상 접속 가능하면
			for(Integer a : am) {
				for(Integer b : bm) {
					int temp = 0;
					if(a==b) { // 같은 배터리이면 
						temp += list.get(a).perfor;
					}else { // 다른 배터리이면
						temp += list.get(a).perfor;
						temp += list.get(b).perfor;
					}
					max = Math.max(max, temp);
				}
			}
		}else if(am.size() > 0) { // 접속가능한 배터리가 a만 있을 때
			for(Integer a : am) {
				max = Math.max(max, list.get(a).perfor);	
			}
		}else if(bm.size() > 0) { // 접속가능한 배터리가 b만 있을 때
			for(Integer b : bm) {
				max = Math.max(max, list.get(b).perfor);	
			}
		}
		ans += max;
	}
	
	
	static class apinfo {
		int y, x, cover, perfor;

		public apinfo(int y, int x, int cover, int perfor) {
			super();
			this.y = y;
			this.x = x;
			this.cover = cover;
			this.perfor = perfor;
		}
		@Override
		public String toString() {
			return "apinfo [y=" + y + ", x=" + x + ", cover=" + cover + ", perfor=" + perfor + "]";
		}
	}
}