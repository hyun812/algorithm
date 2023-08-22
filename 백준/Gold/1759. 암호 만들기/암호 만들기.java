
import java.io.*;
import java.util.*;

public class Main {
	static int l, c;
	static String[] arr;
	static String[] ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		l = Integer.parseInt(st.nextToken()); // 총 L개로 구성
		c = Integer.parseInt(st.nextToken()); // 주어지는 문자의 개수
		
		arr = new String[c];
		visited = new boolean[c];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		check(0, 0, 0, "");
	}
	
	private static void check(int pcnt, int ccnt, int start, String target) {
		if(pcnt >=1 && ccnt >=2 && target.length()==l) {
			System.out.println(target);
		}
		
		for(int i=start; i<c; i++) {
			if(!visited[i]) {
				target += arr[i];
				visited[i] = true;
				if(pc(arr[i])) {
					check(pcnt+1, ccnt, i+1, target);
					visited[i] = false;
					target = target.substring(0, target.length() - 1);
				}else {
					check(pcnt, ccnt+1, i+1, target);
					visited[i] = false;
					target = target.substring(0, target.length() - 1);
				}
				
			}
		}
	}
	
	private static boolean pc(String s) {
		if("aioue".contains(s)) {
			return true;
		}
		
		return false;
	}
	
	
	
}