

import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> hm = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String name = bf.readLine();
			hm.put(i+1, name);
			hm2.put(name, i+1);
		}
		
		String regExp = "^[0-9]+$";
		
		for(int i=0; i<m; i++) {
			String ans = bf.readLine();
			if(ans.matches(regExp)) { // 숫자면
				sb.append(hm.get(Integer.parseInt(ans))).append("\n");
			}else { // 숫자가 아니면
				sb.append(hm2.get(ans)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}