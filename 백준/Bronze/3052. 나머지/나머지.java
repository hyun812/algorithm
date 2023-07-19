import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashSet<Integer> arr = new HashSet<>();
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr.add(n%42);
			  
		}

		System.out.println(arr.size());
		
	}

}
