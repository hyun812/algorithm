
import java.io.*;
import java.util.*;

public class Main {
	static int n,d,k,c;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 접시 수 
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(bf.readLine()); 
		}
		
		
		
		int[] dcnt = new int[d+1];
		
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<k; i++) {
			dcnt[arr[i]]++;
			hs.add(arr[i]);
		}
		int ans = hs.size();
		
		if(dcnt[c] == 0) {
			ans += 1;
		}
		
		
		for(int i=0; i<n; i++) {
			dcnt[arr[i]]--;
			if(dcnt[arr[i]] == 0) { // 내가 연속해서 먹는 곳에는 없지요
				hs.remove(arr[i]);	
			}
			
			int idx = i+k;
			if(idx >= n) idx-=n;
			
			dcnt[arr[idx]]++;
			hs.add(arr[idx]);
			
			int result = hs.size();
			if(dcnt[c] == 0) {
				result +=1;
			}
			
			ans = Math.max(ans, result);
		}
		
		System.out.println(ans);
		
	}
}