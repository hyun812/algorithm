
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());	
			n = Integer.parseInt(st.nextToken()); // n개의 집합
			int m = Integer.parseInt(st.nextToken()); // 주어지는 입력 연산 개수
			
			parents = new int[n+1];
			make();
			sb.append("#").append(tc).append(" ");
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
			
				if(a == 0) {
					union(b,c);
				}else if(a == 1){
					if(find(b)==find(c)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void make() {
//		모든 요소는 자기만 원소를 갖는 단위 서로소 집합이 되게한다. (자신이 곧 대표자인 루트로 표현)
		for(int i=0; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	// 최상위 부모노드 찾기
	private static int find(int a) {
		if(a==parents[a]) return a;
		else {
			int b = find(parents[a]);
			parents[a] = b;
			return b;
		}
	}
	
	// a가 속한 집합과 b가 속한 집합을 합칠수 있다면 합치고 true반환, 아니면 false반환
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; // 합칠수없음 (싸이클 존재)
		// union 처리 ( bRoot를 aRoot 아래로 붙이기! : 임의로)
		parents[bRoot] = aRoot;
		return true;
	}
}
