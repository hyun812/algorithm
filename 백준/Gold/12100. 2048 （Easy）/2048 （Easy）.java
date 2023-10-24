import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int[] nums;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;        
        
        n = Integer.parseInt(bf.readLine()); // 이닝 수
        
        arr = new int[n][n];
        nums = new int[5];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0;j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 방향4개중 5개 뽑기 
        // 순서 상관있으므로 중복 순열
        disc(0);
        
        System.out.println(ans);
        
    }
    
    private static void disc(int cnt) {
    	if(cnt == 5) {
//    		System.out.println(Arrays.toString(nums));
    		game();
    		return;
    	}
    	
    	for(int i=0; i<4; i++) {
    		nums[cnt] = i;
    		disc(cnt+1);
    	}
    }
    
    private static void game() {
    	int[][] copy = new int[n][n];
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			copy[i][j] = arr[i][j];
    		}
    	}
    	
    	for(int i=0; i<nums.length; i++) {
//    		System.out.println(nums[i]);
//    		print(copy);
    		switch(nums[i]) {
    		case 0 :
    			up(copy);
    			break;
    		case 1 :
    			down(copy);
    			break;
    		case 2 :
    			left(copy);
    			break;
    		case 3 :
    			right(copy);
    			break;
    		}
//    		print(copy);
    	}
    	
    	int max = 0;
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			max = Math.max(max, copy[i][j]);
    		}
    	}
    	
    	ans = Math.max(max, ans);
    }
    
    // 위로 이동시키는 경우
    private static void up(int[][] copy) {
    	Queue<int[]> q = new LinkedList<>();
    	
    	for(int i=0; i<n; i++) { // 가로 줄
    		for(int j=0; j<n; j++) { // 세로 줄
    			if(copy[j][i] == 0) continue;
    			q.add(new int[] {j, i});
    		}
    		
    		int idx = 0;
    		while(!q.isEmpty()) {
    			int[] poll = q.poll();
    			int target = copy[poll[0]][poll[1]];
    			
    			if(!q.isEmpty()) { // 큐가 비어있지 않고 서로 값이 같으면
    				int[] peek = q.peek();
    				int peekTarget = copy[peek[0]][peek[1]];
    				
    				if(target == peekTarget) {
    					target += target;
    					q.poll();
    				}
    				
    			}
    			copy[idx][i] = target;
    			idx++;
    		}
    		
    		for(int j=idx; j<n; j++) {
    			copy[j][i] = 0;
    		}
		}
	}
    	
    // 아래로 이동시키는 경우
    private static void down(int[][] copy) {
    	Queue<int[]> q = new LinkedList<>();
    	
    	for(int i=0; i<n; i++) { // 가로 줄
    		for(int j=n-1; j>=0; j--) { // 세로 줄
    			if(copy[j][i] == 0) continue;
    			q.add(new int[] {j, i});
    		}
    		
    		int idx = n-1;
    		while(!q.isEmpty()) {
    			int[] poll = q.poll();
    			int target = copy[poll[0]][poll[1]];
    			
    			if(!q.isEmpty()) { // 큐가 비어있지 않고 서로 값이 같으면
    				int[] peek = q.peek();
    				int peekTarget = copy[peek[0]][peek[1]];
    				
    				if(target == peekTarget) {
    					target += target;
    					q.poll();
    				}
    				
    			}
    			copy[idx][i] = target;
    			idx--;
    		}
    		for(int j=idx; j>=0; j--) {
    			copy[j][i] = 0;
    		}
		}
	}
    
    // 왼쪽로 이동시키는 경우
    private static void left(int[][] copy) {
    	Queue<int[]> q = new LinkedList<>();
    	
    	for(int i=0; i<n; i++) { // 세로줄
    		for(int j=0; j<n; j++) { // 가로줄
    			if(copy[i][j] == 0) continue;
    			q.add(new int[] {i, j});
    		}
    		
    		int idx = 0;
    		while(!q.isEmpty()) {
    			int[] poll = q.poll();
    			int target = copy[poll[0]][poll[1]];
    			
    			if(!q.isEmpty()) { // 큐가 비어있지 않고 서로 값이 같으면
    				int[] peek = q.peek();
    				int peekTarget = copy[peek[0]][peek[1]];
    				
    				if(target == peekTarget) {
    					target += target;
    					q.poll();
    				}
    				
    			}
    			copy[i][idx] = target;
    			idx++;
    		}
    		
    		for(int j=idx; j<n; j++) {
    			copy[i][j] = 0;
    		}
		}
	}
    
    // 오른쪽으로 이동시키는 경우
    private static void right(int[][] copy) {
    	Queue<int[]> q = new LinkedList<>();
    	
    	for(int i=0; i<n; i++) { // 세로줄
    		for(int j=n-1; j>=0; j--) { // 가로줄
    			if(copy[i][j] == 0) continue;
    			q.add(new int[] {i, j});
    		}
    		
    		int idx = n-1;
    		while(!q.isEmpty()) {
    			int[] poll = q.poll();
    			int target = copy[poll[0]][poll[1]];
    			
    			if(!q.isEmpty()) { // 큐가 비어있지 않고 서로 값이 같으면
    				int[] peek = q.peek();
    				int peekTarget = copy[peek[0]][peek[1]];
    				
    				if(target == peekTarget) {
    					target += target;
    					q.poll();
    				}
    				
    			}
    			copy[i][idx] = target;
    			idx--;
    		}
    		
    		for(int j=idx; j>=0; j--) {
    			copy[i][j] = 0;
    		}
		}
	}
    
    private static void print(int[][] copy) {
    	for(int i=0; i<n; i++) {
    		System.out.println(Arrays.toString(copy[i]));
    	}
    	System.out.println();
    }
}