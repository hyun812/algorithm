
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            deque.addLast(i+1);
        }
        sb.append("<");

        int cnt = 1;
        while(deque.size() != 1){
            if(cnt == k){
                int num = deque.pollFirst();
                sb.append(num).append(", ");
                cnt = 1;
            }
            else{
                deque.addLast(deque.pollFirst());
                cnt++;
            }
        }

        sb.append(deque.peek()).append(">");

        System.out.println(sb.toString());
        
       
    }
}