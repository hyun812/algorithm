
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] result = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
			result[i] = i+1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			while (a < b){
				int temp = arr[a];
				arr[a] = arr[b];
				arr[b] = temp;
				a++;
				b--;
			}
			
			
		}
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
