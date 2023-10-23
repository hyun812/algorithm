import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int[] nums;
	static boolean[] visited;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;        
        
        n = Integer.parseInt(bf.readLine()); // 이닝 수

        arr = new int[n][10];
        nums = new int[10];
        visited = new boolean[10];
        ans = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=1; j<=9; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        // 0번 자리는 고정으로 4번선수임
        
        // 나머지 사람들에 한해 뽑기
        // 이닝별로 뽑을 필요가 없음 이유는 한번 뽑으면 그 후부터는 순서대로 쭉 가기 때문에
        nums[4] = 1;
    	comb(1);
    	
        System.out.println(ans);
    }
    private static void comb(int cnt) {
    	if(cnt == 10) {
    		play();
    		return;
    	}
    	
    	if(cnt == 4) {
    		comb(cnt+1);
    		return;
    	}
    	
    	for(int i=2; i<=9; i++) {
    		if(visited[i]) continue;
    		nums[cnt] = i;
    		visited[i] = true;
    		comb(cnt+1);
    		visited[i] = false;
    	}
    }
    
    private static void play() {
    	int inning = 0;
    	int score = 0;
    	int outCnt = 0;
    	int last = 1;
    	boolean[] field = new boolean[3]; // 1루 2루 3루 홈 순서로 사람이 있는지 없는지 체크하기 위함
    	// 이닝 시작
    	while(inning < n) {
    		// 아웃카운트가 3이면 종료
    		if(outCnt == 3) {
				outCnt = 0;
				field = new boolean[3];
				inning++;
				continue;
			}
    		
    		int num = arr[inning][nums[last]];
    		
    		switch(num) {
    		case 0 :
    			outCnt++;
    			break;
    		case 1 :
    			// 점수를 얻을 수 있는 위치에 있는 사람이면
    			if(field[2]) {
    				field[2] = false;
    				score++;
    			}
    			for(int j=1; j>=0; j--) {
    				if(field[j]) {
    					field[j] = false;
    					field[j+1] = true;
    				}
    			}
    			field[0] = true;
    			break;
    		case 2 :
    			for(int j=1; j<3; j++) {
    				if(field[j]) {
        				field[j] = false;
        				score++;
        			}	
    			}
    			if(field[0]) {
    				field[0] = false;
    				field[2] = true;
    			}
    			
    			field[1] = true;
    			break;
    		case 3 :
    			for(int j=0; j<3; j++) {
    				if(field[j]) {
        				field[j] = false;
        				score++;
        			}	
    			}
    			field[2] = true;
    			break;
    		case 4 :
    			int cnt = 1;
    			for(int j=0; j<3; j++) {
    				if(field[j]) {
    					cnt++;
    					field[j] = false;
    				}
    			}
    			score += cnt;
    			break;
    		}
    		if(last == 9) {
    			last = 1;
    		}else {
    			last++;
    		}
    	}
    	ans = Math.max(ans, score);
    }
}