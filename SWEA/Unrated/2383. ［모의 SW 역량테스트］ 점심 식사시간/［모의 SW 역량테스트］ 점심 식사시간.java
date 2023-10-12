import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[][] arr;
    static ArrayList<person> list;
    static int sy1, sx1, sk1, sy2, sx2, sk2;
    static int ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 개수
        int t = Integer.parseInt(bf.readLine());

        // 테스트 케이 개수 만큼 반복
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(bf.readLine()); // 배열 크기
            
            arr = new int[n][n];
            list = new ArrayList<>();
            ans = Integer.MAX_VALUE;
            
            int cnt = 0;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1) {
                        list.add(new person(i, j, 0, 0));
                    }else if(arr[i][j] > 1) {
                        if(cnt == 0) {
                            sy1 = i;
                            sx1 = j;
                            sk1 = arr[i][j];
                            cnt++;
                        }else {
                            sy2 = i;
                            sx2 = j;
                            sk2 = arr[i][j];
                        }
                    }
                }
            }
            select(0);
            
            System.out.println("#"+tc+" "+(ans+1));
        }
    }
    
    private static void select(int cnt) {
        // 사람 수 만큼 다 뽑았으면
        if(cnt == list.size()) {
            Collections.sort(list);
            solution();
            return;
        }
        
        person p = list.get(cnt);
        p.stairs = 1;
        p.dis = getDistance(p.y, p.x, 1);
        select(cnt+1);
        
        p.stairs = 2;
        p.dis = getDistance(p.y, p.x, 2);
        select(cnt+1);
        
    }
    
    // 계단에 도착하고 1분후 내려갈 수 있음 + 이후 k만큼
    private static void solution() {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).stairs == 1) {
                q1.add(list.get(i).dis);
            }else {
                q2.add(list.get(i).dis);
            }
        }
        int max = 0; // 계단1과 계단2중 최대값
        
        int time[] = new int[100];
        int endTime = 0;
        while(!q1.isEmpty()) {
            int poll = q1.poll();
            endTime = poll + sk1;
            
            for(int i=poll; i<endTime; i++) {
            	if(time[i] == 3) {
            		endTime++;
            		continue;
            	}
            	time[i]++;
            }
            if(max < endTime) {
            	max = endTime;
            }
        }
        
        time = new int[100];
        endTime = 0;
        while(!q2.isEmpty()) {
            int poll = q2.poll();
            endTime = poll + sk2;
            
            for(int i=poll; i<endTime; i++) {
            	if(time[i] == 3) {
            		endTime++;
            		continue;
            	}
            	time[i]++;
            }
            if(max < endTime) {
            	max = endTime;
            }
        }
        
        ans = Math.min(ans, max);
    }
    
    private static int getDistance(int y, int x, int num) {
        if(num == 1) {
            return Math.abs(y-sy1)+Math.abs(x-sx1);
        }else {
            return Math.abs(y-sy2)+Math.abs(x-sx2);
        }
    }
    
    
    
    static class person implements Comparable<person> {
        int y, x, stairs, dis;

        public person(int y, int x, int stairs, int dis) {
            super();
            this.y = y;
            this.x = x;
            this.stairs = stairs;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "person [y=" + y + ", x=" + x + ", stairs=" + stairs + ", dis=" + dis + "]";
        }

        @Override
        public int compareTo(person o) {
            if(this.stairs != o.stairs) {
                return this.stairs - o.stairs;
            }else {
                return this.dis - o.dis;
            }
        }
        
        
    }
}

//for(int i=0; i<list.size(); i++) {
//    System.out.println(list.get(i));
//}
//System.out.println();