import java.io.*;
import java.util.*;

public class Solution {
	static int m, a;
	static int[] user1, user2;
	static ArrayList<BC> bcList;
	static int y1, y2, x1, x2;
	static int[] dy = {0, 0, 1, 0, -1}; // 상 우 하 좌
	static int[] dx = {0, -1, 0, 1, 0}; // 상 우 하 좌

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스 개수
		int t = Integer.parseInt(bf.readLine());

		// 테스트 케이 개수 만큼 반복
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken()); // 이동 시간
			a = Integer.parseInt(st.nextToken()); // bc의 개수

			user1 = new int[m]; // A의 정보를 담을 배열
			user2 = new int[m]; // B의 정보를 담을 배열
			ans = 0;
			bcList = new ArrayList<>();

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < m; i++) {
				user1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < m; i++) {
				user2[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(bf.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cover = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());

				bcList.add(new BC(y, x, cover, power));
			}
			move();
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	// 이동하기
	private static void move() {
		y1 = x1 = 1;
		y2 = x2 = 10;
		
		getBattery();
		
		for (int i = 0; i < m; i++) {

			// 사용자 A 이동시키기
			y1 += dy[user1[i]];
			x1 += dx[user1[i]];

			// 사용자 B 이동시키기
			y2 += dy[user2[i]];
			x2 += dx[user2[i]];

			getBattery();

		}
	}

	// 배터리 확인 후 충전한 양 계산하기
	private static void getBattery() {
		ArrayList<Integer> cv1 = new ArrayList<>();
		ArrayList<Integer> cv2 = new ArrayList<>();
		
		for(int i=0; i<a; i++) { // bc의 개수만큼 반복
			BC bc = bcList.get(i);
			
			// 사용자 A가 해당 bc의 범위 안에 있을 때 list에 추가
			if(getDistance(y1, x1, bc.y, bc.x) <= bc.cover) {
				cv1.add(i);
			}
			// 사용자 B가 해당 bc의 범위 안에 있을 때 list에 추가
			if(getDistance(y2, x2, bc.y, bc.x) <= bc.cover) {
				cv2.add(i);
			}
		}
		
		int max = 0;
		
		// 둘다 1보다 크면
		if(cv1.size() >= 1 && cv2.size() >= 1) {
			for(Integer i : cv1) {
				for(Integer j : cv2) {
					int temp = 0;
					if(i==j) { // 같은 범위안에 있으면
						temp += bcList.get(i).power;
					}else {
						temp += bcList.get(i).power;
						temp += bcList.get(j).power;
					}
					max = Math.max(max, temp);
				}
			}
		}else if(cv1.size() >= 1) {
			for(Integer i : cv1) {
				max = Math.max(max, bcList.get(i).power);
			}
		}else if(cv2.size() >= 1) {
			for(Integer i : cv2) {
				max = Math.max(max, bcList.get(i).power);
			}
		}
		
		ans += max;
	}

	// 거리 계산 함수
	private static int getDistance(int y, int x, int bcy, int bcx) {
		return Math.abs(bcy - y) + Math.abs(bcx - x);
	}

	static class BC {
		int y, x, cover, power;

		public BC(int y, int x, int cover, int power) {
			super();
			this.y = y;
			this.x = x;
			this.cover = cover;
			this.power = power;
		}
	}
}