
import java.io.*;
import java.util.*;

//누적합을 사용하면 시간초과
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1]+ Integer.parseInt(st.nextToken()) - arr[i-1][j-1];  
			}
		}
//		
//		for(int i=0; i<=n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start_x = Integer.parseInt(st.nextToken()); // 2
			int start_y = Integer.parseInt(st.nextToken()); // 2
			
			int end_x = Integer.parseInt(st.nextToken()); // 3
			int end_y = Integer.parseInt(st.nextToken()); // 4
			// 1 1 4 4
			// (3,4) - (1,4) - (3,1) + (1,1)
			// (end_X , end_y)   - ( end_x-start_x, end_y) - (end_x, end_y-start_y-1) + (start_x-1, start_y-1)
			int a = arr[end_x][end_y];
			int b = arr[start_x-1][end_y];
			int c = arr[end_x][start_y-1];
			int d = arr[start_x-1][start_y-1];
			int result = a - b - c + d;
			System.out.println(result);
		}
	
	}
}
// 0 0 0 0 0
// 0 1 3 6 10
// 0 3 



