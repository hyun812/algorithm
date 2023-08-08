
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			int card = Integer.parseInt(st.nextToken());
			hm.put(card, hm.getOrDefault(card, 0)+1);
		}
		
		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<m; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if(hm.get(target) == null) {
				sb.append(0).append(" ");
			}
			else {
				sb.append(hm.get(target)).append(" ");	
			}
			
		}
		
		System.out.println(sb.toString());
	}
}