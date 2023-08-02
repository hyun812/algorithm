import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			
			int[][] arr = new int[9][9];
			int[] check;
			boolean flag = false;

			for(int i=0; i<9; i++) {//스도쿠 입력받기
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i<9; i++) {//가로 탐색
				check = new int[9];
				for(int j=0; j<9; j++) {
					check[arr[i][j]-1]=1;//가로 탐색
				}

				for(int z=0; z<9; z++) {
					if(check[z] == 0) {
						flag = true;
						break;
					}
				}
			}

			//세로 탐색
			for(int i=0; i<9; i++) {
				check = new int[9];
				for(int j=0; j<9; j++) {
					check[arr[j][i]-1]=1;//세로 탐색
				}
				for(int z=0; z<9; z++) {
					if(check[z] == 0) {
						flag = true;
						break;
					}
				}
			}

			//3x3체크
			check = new int[9];
			for(int i = 0; i<=6; i+=3) {

				for(int j=0; j<=6; j+=3) {
					check = new int[9];
					for(int x = i; x<i+3; x++) {
						for(int y = j; y<j+3; y++) {
							check[arr[x][y]-1]=1;
						}
					}
				}
				for(int z=0; z<9; z++) {
					if(check[z] == 0) {
						flag = true;
						break;
					}
				}
			}
            int result = flag ? 0 : 1;
            
            System.out.println("#"+t+" "+result);

        }
    }
}