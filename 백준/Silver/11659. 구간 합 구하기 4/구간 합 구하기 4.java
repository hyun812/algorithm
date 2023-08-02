
import java.io.*;
import java.util.*;

//누적합을 사용하면 시간초과
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		arr[0] = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			
			System.out.println(arr[end] - arr[start-1]);
		}
	
	}
}

// 0 5 9 12 14 15
// 



