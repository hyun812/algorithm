import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static int[] nums;
    static int ans;
    static int first, second;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());        
        
        n = Integer.parseInt(st.nextToken()); // n개의 건물 ( 1번부터 n번의 번호를 가짐) 양방향
        m = Integer.parseInt(st.nextToken()); // m개의 도로
        
        arr = new int[n+1][n+1];
        nums = new int[2];
        ans = Integer.MAX_VALUE;
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
        
        comb(1, 0);
        // 2개의 매장을 지음
        // 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단시간의 총합
        System.out.println(first+" "+second+" "+ans);
    }
    
    private static void comb(int start, int cnt) {
        if(cnt == 2) {
            int time = bfs(nums);
            
            if(ans > time) {
            	first = nums[0];
            	second = nums[1];
            	ans = time;
            }
            
            return;
        }
        
        for(int i=start; i<=n; i++) {
            nums[cnt] = i;
            comb(i+1, cnt+1);
        }
    }
    
    private static int bfs(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for(int i=0; i<2; i++) {
            q.add(nums[i]);
            visited[nums[i]] = 0;
            
            while(!q.isEmpty()) {
                int poll = q.poll();
                
                for(int j=1; j<=n; j++) {
                    if(arr[poll][j] != 1) continue; // 갈수없으면 continue
                    if(visited[j] == 0) continue;
                    if(visited[j] > visited[poll] + 1) {
                        visited[j] = visited[poll] + 1;
                        q.add(j);
                    }
                    
                }
            }
            
        }
//        System.out.println(Arrays.toString(visited));
        int temp = 0;
        for(int i=1; i<=n; i++) {
        	temp += visited[i];
        }
        
        return temp*2;
    }
}