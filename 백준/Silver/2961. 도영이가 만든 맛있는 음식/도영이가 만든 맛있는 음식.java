
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int min = Integer.MAX_VALUE;
	static int taa[];
	static int tab[];
	static int n;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		taa = new int[n];
		tab = new int[n];
		isSelected = new boolean[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			taa[i] = Integer.parseInt(st.nextToken());
			tab[i] = Integer.parseInt(st.nextToken());
			
		}
		check(0);
		
		System.out.println(min);
	}
	
	// 신맛은 곱 
	// 쓴맛은 합
	private static void check(int cnt) {
		if(cnt == n) {
			int ta = 1;
			int tb = 0;
			int ze = 0;
			for(int i=0; i<n; i++) {
				if(isSelected[i]) {
					ta *= taa[i];
					tb += tab[i];
					ze++;
				}
			}
			if(ze != 0) {
				min = Math.min(Math.abs(tb-ta), min);	
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		check(cnt+1);
		isSelected[cnt] = false;
		check(cnt+1);
		
	}

}
