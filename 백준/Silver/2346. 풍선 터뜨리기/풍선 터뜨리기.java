
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            deque.addLast(i);    
        }

        // 0  3  2  1 -3 -1  안에든거
        // 0  1  2  3  4  5  인덱스
        sb.append(deque.peekFirst()).append(" ");
        deque.pollFirst();
        int num = 1;
        while(!deque.isEmpty()){
            int cnt = arr[num];    
            if(cnt > 0){
                for(int i=0; i<cnt-1; i++){
                    deque.addLast(deque.pollFirst());
                }
                num = deque.pollFirst();
                sb.append(num).append(" ");
            }else{
                cnt = cnt*-1;
                for(int i=0; i<cnt-1; i++){
                    deque.addFirst(deque.pollLast());
                }
                num = deque.pollLast();
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString());
        
    }   
}