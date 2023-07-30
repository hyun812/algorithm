

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] x = new int[3];
		int[] y = new int[3];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		int rex = x[0];
		int rey = y[0];
		
		if(x[0] == x[1]) {
			rex = x[2];
		}else if(x[0] == x[2]) {
			rex = x[1];
		}
		
		if(y[0] == y[1]) {
			rey = y[2];
		}else if(y[0] == y[2]) {
			rey = y[1];
		}
		
		System.out.println(rex + " " + rey);
		
		
		
		
	}
}