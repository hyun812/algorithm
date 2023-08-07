
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<int[]> stack = new Stack<>();
	static int[] arr;
	static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		result = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.add(new int[] {n-1, arr[n-1]});
		
		for(int i=n-2; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek()[1] < arr[i]) {
				result[stack.peek()[0]] = i+1;
				stack.pop();
			}
			stack.add(new int[] {i, arr[i]});
		}
		
		
		for(int i=0; i<n; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
		
}
