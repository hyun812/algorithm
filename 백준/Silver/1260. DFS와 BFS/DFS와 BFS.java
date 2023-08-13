import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> s = new Stack<>();
    static int[][] arr;
    static boolean[] bfsV;
    static boolean[] dfsV;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new int[vertex+1][vertex+1];
        bfsV = new boolean[vertex+1];
        dfsV = new boolean[vertex+1];

		for(int i=0; i<edge; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");
        bfs(start);
        
		
        System.out.println(sb.toString());
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        bfsV[start] = true;
        sb.append(start).append(" ");

        while(!q.isEmpty()){
            int poll = q.poll();

            for(int i = 0; i < arr[poll].length; i++){
                if(!bfsV[i] && arr[poll][i] == 1){
                    q.offer(i);
                    bfsV[i]= true;

                    sb.append(i).append(" ");
                }
            }
        }
        sb.append("\n");
    }

    public static void dfs(int start){
        dfsV[start] = true;
        sb.append(start).append(" ");

       for(int i = 0; i < arr[start].length; i++){
            if(!dfsV[i] && arr[start][i] == 1){
                dfs(i);
            }
        }
    }
}
