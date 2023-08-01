
import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] arr;
	static int[] pos = new int[2];
	
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for (int tc = 1; tc <= 10; tc++) {
			arr = new int[100][100];
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					if(arr[i][j] == 2) {
						pos[0] = i;
						pos[1] = j;
					}
				}
			}
			check();
			System.out.println("#"+tc+" "+pos[1]);
		}

	}
	
	public static void check() {
		while(true) {
			if(pos[0] == 0) { // 출발지점일때
				break;
			}
			
			if(outidx(pos[0], pos[1]-1) && arr[pos[0]][pos[1]-1] == 1) { // 왼쪽 길있는지 확인
				while(true) { 
					if(!outidx(pos[0], pos[1]-1)) break;
					if(arr[pos[0]][pos[1]-1] == 0) break; // 왼쪽길이 없을 때 까지 쭉
					pos[1] -= 1; 
				}
				pos[0] -= 1; // 위로 한칸
			}else if(outidx(pos[0], pos[1]+1) && arr[pos[0]][pos[1]+1] == 1) { // 오른쪽 길있는지 확인
				while(true) {
					if(!outidx(pos[0], pos[1]+1)) break;
					if(arr[pos[0]][pos[1]+1] == 0) break; // 오른쪽 길이 없을 때 까지 쭉
					pos[1] += 1; 
				}
				pos[0] -= 1; // 위로 한칸
				
			}else {
				pos[0] -= 1; // 위로
			}
		}
	}
	
	public static boolean outidx(int x , int y) {
		if(x >= 0 && x<100 && y>=0 && y<100) {
			return true;
		}
		
		return false;
	}
}









