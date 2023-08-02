import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(bf.readLine());
			String s = st.nextToken();
			
			String initbit = "0";
			
			int cnt = 0;
			for(int j=0; j<s.length(); j++) {
				String target = s.split("")[j];
				if(!target.equals(initbit)){
					initbit = s.split("")[j];
					cnt++;
				}
			}
			
			System.out.println("#" + i + " " + cnt);
		}
	}

}
