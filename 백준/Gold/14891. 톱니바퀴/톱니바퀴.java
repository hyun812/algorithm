import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int[][] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[4][8];
		check = new int[4][2];
		
		for(int i=0; i<4; i++) {
			String[] s = bf.readLine().split("");
			for(int j=0; j<8; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		checkFill(); // 맞닿은 부분 찾기
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken()); // 회전시킬 톱니바퀴 번호
			int dis = Integer.parseInt(st.nextToken()); // 1이면 시계방향, -1이면 반시계 방향
			
			rotate(num-1, dis);
			checkFill();
		}
		
		int ans = 0;
		for(int i=0; i<4; i++) {
			if(arr[i][0] == 1) {
				ans += Math.pow(2, i);
			}
		}
		System.out.println(ans);
		
	}
	
	// 맞닿은 극이 서로 다르다면 반대반향으로 회전
	// 같으면 회전하지 않음
	private static void rotate(int num, int dis) {
		int[] ro = new int[4]; // 0이면 유지, 1이면 시계, -1이면 반시계
		
		ro[num] = dis;
		int low = num;
		int lowdis = dis;
		int high = num;
		int highdis = dis;
		
		// 번호가 작은 톱니바퀴 확인하기
		while(low >= 1) {
			if(check[low][0] == check[low-1][1]) {
				break;
			}else {
				ro[low-1] = lowdis*-1;
			}
			
			lowdis *= -1;
			low--;
		}
		
		// 번호가 큰 톱니바퀴 확인하기
		while(high < 3) {
			if(check[high][1] == check[high+1][0]) {
				break;
			}else {
				ro[high+1] = highdis*-1;
			}
			
			highdis *= -1;
			high++;
		}
		
		for(int i=0; i<4; i++) {
			if(ro[i] == 0) continue;
			
			if(ro[i] == 1) {
				clock(i);
			}else {
				reverseClock(i);
			}
		}
	}
	
	// 0에 7 / 7에 6 / 6에 5 / 5에 4 / 4에 3 ...
	// 시계방향
	private static void clock(int num) {
		int temp = arr[num][7];
		for(int i=7; i>0; i--) {
			arr[num][i] = arr[num][i-1];
		}
		arr[num][0] = temp;
	}
	
	// 반시계방향
	private static void reverseClock(int num) {
		int temp = arr[num][0];
		for(int i=0; i<7; i++) {
			arr[num][i] = arr[num][i+1];
		}
		arr[num][7] = temp;
	}
	
	
	private static void checkFill() {
		check[0] = new int[] {0, arr[0][2]};
		check[1] = new int[] {arr[1][6], arr[1][2]};
		check[2] = new int[] {arr[2][6], arr[2][2]};
		check[3] = new int[] {arr[3][6], 0};
	}
	
}