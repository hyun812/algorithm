
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());

		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			
			int[] garr = new int[9];
			int[] iarr = new int[9];
			boolean[] ck = new boolean[18];
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				garr[i] = num;
				ck[num-1] = true;
			}
			
			int idx = 0;
			for(int i=0; i<18; i++) {
				if(!ck[i]) {
					iarr[idx++] = i+1;
				}
			}
			
			Arrays.sort(iarr); // 오름차순의 형태로 정렬
			
			int gwin = 0;
			
			do {
				int gscore = 0;
				int iscore = 0;
				for(int i=0; i<9; i++) {
					if(garr[i] > iarr[i]) {
						gscore += (garr[i]+iarr[i]);
					}else if(garr[i] < iarr[i]) {
						iscore += (garr[i]+iarr[i]);
					}
				}
				
				if(gscore > iscore) {
					gwin++;
				}				
			} while(np(iarr));
			sb.append("#").append(tc).append(" ").append(gwin).append(" ").append(362880-gwin).append("\n");
		}
		
		
		System.out.println(sb.toString());

	}
	
	private static boolean np(int[] p) { // p : 다음 순열을 원하는 기존 순열의 배열
		// 1. 맨 뒤쪽부터 탐색하며 꼭대기 찾기
		int N = p.length;
		int i = N-1;
		
		while(i>0 && p[i-1] >= p[i]) --i; // i>0조심
		
		if(i == 0) return false; // 다음 순열이 없음 ( 가장 큰 순열의 형태 )
		
		// 2. 꼭대기 직전 ( i-1 )위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
		int j= N-1;
		while(p[i-1] >= p[j]) --j;
		
		// 3. 꼭대기 직전 ( i-1 )위치의 수와 한단계 큰 수를 교환하기
		swap(p,i-1,j);
		
		// 4. 꼭대기자리 부터 맨 뒤까지의 수를 오름차순의 형태로 바꿈
		int k = N-1;
		while(i<k) {
			swap(p, i++, k--);
			
		}
		
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a]  = p[b];
		p[b] = temp; 
	}
}
