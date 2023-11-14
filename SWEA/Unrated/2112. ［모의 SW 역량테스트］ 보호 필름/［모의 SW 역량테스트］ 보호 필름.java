import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, k;
	static int[][] arr;
    static int[] ans;
    static int res;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(bf.readLine());
        
        for(int tc=1; tc<=t; tc++) {
        	st = new StringTokenizer(bf.readLine());
 
        	n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken()); // 합격 기준
            
            res = Integer.MAX_VALUE;
            arr = new int[n][m];
            ans = new int[n];
            Arrays.fill(ans, -1);
            
            for(int i=0; i<n; i++) {
            	st = new StringTokenizer(bf.readLine());
            	for(int j=0; j<m; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            doit(0, 0);
            
            System.out.println("#"+tc+" "+res);
        }
    }
    
    
    private static void doit(int idx, int cnt) {
    	if(cnt >= res) return;
    	
    	if(idx == n) {
    		int[][] copy = new int[n][m];
    		// 채우기
    		fill(copy);
    		// 성능검사 하기
    		if(check(copy)) {
    			res = Math.min(res, cnt);
			}
    		
    		return;
    	}
    	// 투입하지 않을 때
    	ans[idx] = -1;
    	doit(idx+1, cnt);
    	
    	// A로 투입할 때
    	ans[idx] = 0;
    	doit(idx+1, cnt+1);
    	
    	// B로 투입할 때
    	ans[idx] = 1;
    	doit(idx+1, cnt+1);
    	
    }
    
    private static void fill(int[][] copy) {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			copy[i][j] = arr[i][j];
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		if(ans[i] == -1) continue;
    		
    		for(int j=0; j<m; j++) {
    			copy[i][j] = ans[i];
    		}
    	}
    }
    
    private static boolean check(int[][] copy) {
    	for(int i=0; i<m; i++) {
    		int cnt = 1;
    		int cur = copy[0][i];
    		boolean flag = false;
    		for(int j=1; j<n; j++) {
    			if(cur == copy[j][i]) {
    				cnt++;
    			}else {
    				cur = copy[j][i];
    				cnt = 1;
    			}
    			
    			if(cnt >= k) {
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) return false;
    	}
    	return true;
    }
}