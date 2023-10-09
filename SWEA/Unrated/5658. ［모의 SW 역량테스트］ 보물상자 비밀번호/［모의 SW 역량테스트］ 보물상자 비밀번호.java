import java.io.*;
import java.util.*;

public class Solution {
	static int n, k;
	static boolean[][] visited;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 숫자의 개수
			k  = Integer.parseInt(st.nextToken()); // 몇번째 순서
			
			Deque<String> q = new ArrayDeque<>();
			HashSet<Long> set = new HashSet<>(); // 중복제거를 위한 set
			
			String[] s = bf.readLine().split("");
			for(int i=0; i<n; i++) {	
				q.add(s[i]);
			}
			
			int cnt = n/4; // 한변에 들어갈 개수, cnt만큼 반복했을 때 다시 돌아옴
			
			for(int k=0; k<cnt; k++) { // 총 반복 횟수 , 이후에는 같아짐
				
				for(int i=0; i<4; i++) { // 변4개 확인
					StringBuilder sb = new StringBuilder();
					for(int j=0; j<cnt; j++) { // 한변 확인
						String poll = q.poll();
						sb.append(poll);
						q.add(poll);
					}
					set.add(Long.parseLong(sb.toString(), 16));	
				}
				
				String target = q.pollLast();
				q.addFirst(target);
			}
			
			List<Long> li = new ArrayList<>(set);
			Collections.sort(li, Collections.reverseOrder());
			ans = li.get(k-1);
			System.out.println("#"+tc+" "+ans);
		}
	}

}