import java.io.*;
import java.util.*;

public class Solution {
	static int n,m; 
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 정점의 수
			m = Integer.parseInt(st.nextToken()); // 간선의 수
			
			make();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from, to); // 합치기
			}
			
			int ans = 0;
			// 부모값이 자기 자신과 같으면 그룹
			for(int i=1; i<arr.length; i++) {
				if(arr[i] == i) {
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	// 모든 요소를 자기 자신으로 초기화
	private static void make() {
		arr = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
	}
	
	// a와 b를 합칠 수 있으면 true, 아니면 false
	private static boolean union(int a, int b) {
		int aRoot = find(a); //
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		arr[bRoot] = aRoot;
		return true;
		
	}
	
	// 최상위 부모노드 찾기
	private static int find(int a) {
		if(a == arr[a]) return a;
		else {
			// 최상위 노드를 배열의 값으로 설정
			int b = find(arr[a]);
			arr[a] = b;
			return b;
		}
	}
}