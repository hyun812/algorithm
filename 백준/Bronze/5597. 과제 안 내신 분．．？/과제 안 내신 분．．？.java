import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[] arr = new boolean[30];
		for(int i=0; i<28; i++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr[n-1] = true;  
		}
				
		for(int i=0; i<30; i++) {
			if(!arr[i]) {
				System.out.println(i+1);	
			}
			
		}
	}

}
