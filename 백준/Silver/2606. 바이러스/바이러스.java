import java.io.*;
import java.util.*;

public class Main {
    // static StringBuilder sb = new StringBuilder();
    static int ver;
    static int edge;
    static int[][] arr;
    static boolean[] visited;
    static Stack<Integer> s = new Stack<>();
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ver = Integer.parseInt(bf.readLine());
        edge = Integer.parseInt(bf.readLine());

        arr = new int[ver+1][ver+1];
        visited = new boolean[ver+1];

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;

        }
        
        dfs(1);

        System.out.println(result-1);
    }

    public static void dfs(int start){
        
        visited[start] = true;
        result++;

        for(int i=0; i<arr[start].length; i++){
            if(!visited[i] && arr[start][i] == 1){
                dfs(i);
            }
        }

    }

    // public static boolean outOfIndex(int y, int x){
    //     if(y>=0 && y<n && x>=0 && x<m){
    //         return true;
    //     }
        
    //     return false;
    // }

    // static int[] dy = {0, 1, 0, -1};
    // static int[] dx = {1, 0, -1, 0};
}
