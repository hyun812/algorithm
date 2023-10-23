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
        nums[4] = 1;
        
        // 이닝별로 뽑을 필요가 없음 이유는 한번 순서를 뽑으면 그 후부터는 순서대로 쭉 가기 때문에
        // 순서가 상관있기 때문에 순열로 뽑기
        dice(1);
    	
        System.out.println(ans);
    }
    private static void dice(int cnt) {
    	if(cnt == 10) {
    		play();
    		return;
    	}
    	
    	if(cnt == 4) { // 4번타자는 이미 지정해뒀으므로 넘어가기
    		dice(cnt+1);
    		return;
    	}
    	
    	for(int i=2; i<=9; i++) {
    		if(visited[i]) continue;
    		nums[cnt] = i;
    		visited[i] = true;
    		dice(cnt+1);
    		visited[i] = false;
    	}
    }
    
    private static void play() {
    	int inning = 0;
    	int score = 0;
    	int outCnt = 0;
    	int last = 1;
    	boolean[] field = new boolean[3]; // 1루 2루 3루 순서로 사람이 있는지 없는지 체크하기 위함
    	// 이닝 시작
    	while(inning < n) {
    		// 아웃카운트가 3이면 초기화 후 다음 이닝으로
    		if(outCnt == 3) {
				outCnt = 0;
				field = new boolean[3];
				inning++;
				continue;
			}
    		
    		// 타자가 어떻게 쳤는지
    		int num = arr[inning][nums[last]];
    		
    		switch(num) {
    		case 0 :
    			outCnt++; // 아웃카운트 증가
    			break;
    		case 1 :
    			if(field[2]) { // 3루에 있는 사람만 들어감
    				field[2] = false;
    				score++;
    			}
    			for(int j=1; j>=0; j--) { // 나머지 사람 진루
    				if(field[j]) {
    					field[j] = false;
    					field[j+1] = true;
    				}
    			}
    			field[0] = true; // 1루에 타자 들어옴
    			break;
    		case 2 :
    			for(int j=1; j<3; j++) { // 2루 3루 에 있는 사람만 들어감
    				if(field[j]) {
        				field[j] = false;
        				score++;
        			}	
    			}
    			if(field[0]) { // 1루에 있는 사람 3루로
    				field[0] = false;
    				field[2] = true;
    			}
    			
    			field[1] = true; // 2루에 타자 들어옴
    			break;
    		case 3 :
    			for(int j=0; j<3; j++) { // 타석에 있던 사람 전부 들어감
    				if(field[j]) {
        				field[j] = false;
        				score++;
        			}	
    			}
    			field[2] = true; // 3루에 타자 들어옴
    			break;
    		case 4 :
    			int cnt = 1;
    			for(int j=0; j<3; j++) { // 홈런일 때 필드에 있던 타자 숫자 세기
    				if(field[j]) {
    					cnt++;
    					field[j] = false;
    				}
    			}
    			score += cnt; 
    			break;
    		}
    		
    		if(last == 9) { // 9번타자까지 모두 쳤다면 다시 1번으로
    			last = 1;
    		}else {
    			last++;
    		}
    	}
    	ans = Math.max(ans, score);
    }
}