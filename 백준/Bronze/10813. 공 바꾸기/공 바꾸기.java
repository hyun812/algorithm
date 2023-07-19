import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		 
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			 
			int tmp = arr[j-1];
			arr[j-1] = arr[k-1];
			arr[k-1] = tmp;
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
