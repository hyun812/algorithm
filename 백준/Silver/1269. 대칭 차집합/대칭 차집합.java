
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> hm1 = new HashMap<>();
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			hm1.put(Integer.parseInt(st.nextToken()), 1);
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<m; i++) {
			hm2.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		int concnt = 0;
		for(Integer i : hm1.keySet()) {
			if(hm2.get(i) != null) {
				concnt++;
			}
		}
		
		int result = (hm1.size()-concnt) + (hm2.size()-concnt);
		System.out.println(result);
	}
}