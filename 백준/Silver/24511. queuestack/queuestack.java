
import java.io.*;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        String[] qscheck = bf.readLine().split(" ");
        String[] qsnum = bf.readLine().split(" ");
        
        Queue<String> queue = new LinkedList<>();

        for(int i=n-1; i>=0; i--){
            if(qscheck[i].equals("0")){
                queue.add(qsnum[i]);
            }
        }
        st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<m; i++){
            queue.add(st.nextToken());
            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb.toString());
        
        
    }   
}