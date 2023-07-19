import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = 0;
		int idx = -1;
		
		for(int i=0; i<9; i++) {
			 st = new StringTokenizer(bf.readLine());
			 int target = Integer.parseInt(st.nextToken()); 
			 
			 if(max < target) {
				 max = target;
				 idx = i+1;
			 }
			 
			 
		}
		
		
		
		System.out.println(max);
		System.out.println(idx);
	}

}
