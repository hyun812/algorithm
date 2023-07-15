import java.io.*;
import java.util.*;

public class sw5215 {

	static int score = 0;
	static int[] taste;
	static int[] cal;
	static int L;
	public static void main(String[] args) throws Exception  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			
			taste = new int[N];
			cal = new int[N];
			boolean[] visited = new boolean[N];
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(bf.readLine());
				taste[j] = Integer.parseInt(st.nextToken());
				cal[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=1; j<=N; j++) {
				combination(visited, 0, j);
			}
			
			System.out.println("#" + i + " " + score);
		}
	}
	
	static void combination( boolean[] visited, int start, int r) {
        if(r == 0) {
            check(visited);
            
            return;
        } else {
            for(int i = start; i < cal.length; i++) {
                visited[i] = true;
                combination(visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
	
	static void check(boolean[] visited) {
		int sumScore = 0;
		int sumCal = 0;
        for(int i = 0; i < cal.length; i++) {
            if(visited[i] == true) {
            	sumScore += taste[i];
            	sumCal += cal[i];
            }
        }
        if(sumCal < L && score < sumScore) score = sumScore;
    }
}
