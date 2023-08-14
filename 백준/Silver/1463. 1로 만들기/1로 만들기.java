
import java.io.*;
import java.util.*;


/* 1 > 0
 * 2 > 1   2나누기
 * 3 > 1   3나누기
 * 
 * 4 > 2   2나누기 (2)
 * 5 > 3   1빼기 (4)
 * 6 > 2   2나누기 (3)
 * 
 * 7 > 3   1빼기 (6)
 * 8 > 3   2나누기 (4)
 * 9 > 2   3나누기 (3)
 * 
 * 10 > 3  2나누기 (5)
 * 11 > 4  1빼기 (10)
 * 12 > 3  2나누기 (6)
 * 13 > 4  1빼기 (12)
 * 14 > 4  2나누기 (7)
 * 15 > 4  3나누기 (5)
 */
public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(bf.readLine());
        
        int[] dp = new int[Math.max(n+1, 4)];
        
        
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        
        
        for(int i=4; i<=n; i++) {
        	if(i%2==0 && i%3==0) {
        		dp[i] = Math.min(dp[i-1]+1, Math.min(dp[i/2]+1, dp[i/3]+1));
        	}
        	else if(i%2 == 0) {
        		dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);	
        	}else if(i%3 == 0) {
        		dp[i] = Math.min(dp[i-1]+1, dp[i/3]+1);
        	}else {
        		dp[i] = dp[i-1]+1;
        	}
        }
        
    	System.out.println(dp[n]);	
        
        
    }

}

//41 40 20 10 9 3 1

