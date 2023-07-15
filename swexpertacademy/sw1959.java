import java.util.*;
import java.io.*;


public class sw1959 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
				 
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] a_arr = new int[a];
			int[] b_arr = new int[b];
			
			st = new StringTokenizer(bf.readLine());
		    for(int j=0; j<a; j++){
		    	a_arr[j] =Integer.parseInt(st.nextToken());
	        }
		    
		    st = new StringTokenizer(bf.readLine());
		    for(int j=0; j<b; j++){
		    	b_arr[j] =Integer.parseInt(st.nextToken());
	        }
            
            int result = 0;
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            
            for(int j=0; j<=max-min; j++) {
            	int sum = calc(a_arr, b_arr, j);
            	result = sum>result ? sum : result;
            	
            }
            System.out.println("#"+ (i+1) + " " + result);
		}
	}
	public static int calc(int[] a_arr, int[] b_arr, int cnt) {
		int sum = 0;
		if(a_arr.length > b_arr.length) {
			int[] tmp = b_arr.clone();
			b_arr = a_arr.clone();
			a_arr = tmp.clone();
		}
		
		for(int i=0; i<a_arr.length; i++) {
			sum += a_arr[i] * b_arr[i+cnt];
		}
		return sum;
	}

}
