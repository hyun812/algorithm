import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[] price = new int[4];
	static int[] day = new int[12];
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<12; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			int sum = 0;
			check(cnt, sum);
			
			min = (min > price[3]) ? price[3] : min;
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb.toString());
		
    }
	
	
	// cnt는 day의 인덱스
	public static void check(int cnt, int sum) {
		if(cnt >= 12) {
			min = (min > sum) ? sum : min;
			return;
		}
		
		check(cnt+1, sum + (price[0]*day[cnt])); // 1일
		
		check(cnt+1, sum + (price[1])); // 1달
		
		check(cnt+3, sum + (price[2])); // 3달	
		
			
		
		
	}
}