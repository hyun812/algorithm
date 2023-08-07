
import java.io.*;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            
        int n = Integer.parseInt(bf.readLine());
        int num = 665;
        int cnt = 0;
        while(true){
            if(cnt == n){
                break;
            }
            num++;

            if(Integer.toString(num).contains("666")){
                cnt++;
            }
           
        }

        System.out.println(num);
            
        

    }
}