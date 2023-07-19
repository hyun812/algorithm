
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int max = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = (max < arr[i]) ? arr[i] : max;
		}
		
		double sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += (double)(arr[i])/max * 100;
		}
		
		double result = sum/n;
		System.out.println(Math.round(result*100)/100.0);
	}

}
