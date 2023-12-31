import java.io.*;
import java.util.*;

public class Main {
	static int t, w;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		t = Integer.parseInt(st.nextToken()); // 몇초동안 떨어지는지
		w = Integer.parseInt(st.nextToken()); // 자두가 움직일 수 있는 최대 회수

		arr = new int[t+1];
		for (int i = 1; i <= t; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		// 현재 시간 , 자두가 이동한 횟수
		int[][] dp = new int[t + 1][w + 1];
		
		for(int i=1; i<=t; i++) {
			for(int j=0; j<=w; j++) {
				// 움직임이 없는 경우
                // 나무 1에 떨어지면 1 추가 / 나무 2에 떨어지면 아무일없음
                if(j == 0) {
                    if(arr[i] == 1) 
                        dp[i][j] = dp[i-1][j] + 1;
                    else            
                        dp[i][j] = dp[i-1][j];
 
                    continue;
                }
 
                // 짝수번 움직이면 나무 1
                if(j%2 == 0) {
                    if(arr[i] == 1) 
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else 
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                }
                
                // 홀수번 움직이면 나무 2
                else {
                    if(arr[i] == 1)
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
			}
		}
		
		for(int i=0; i<=w; i++) {
			answer = Math.max(answer, dp[t][i]);
		}
		
		System.out.println(answer);
	}
}