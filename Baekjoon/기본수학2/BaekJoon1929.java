package 기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1929 {
    public static void main(String[] args){
        int a = 0;
        
        for(int i=3; i<100; i*=3){
            a+=i;
        }

        System.out.print(i);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // int min = Integer.parseInt(st.nextToken());
        // int max = Integer.parseInt(st.nextToken());
    
        // boolean[] prime = new boolean[max+1];

        // for(int i=2; i<=max; i++){
        //     if(prime[i]) continue;
            
        //     if(i >= min) sb.append(i).append('\n');

        //     for(int j= i+i; j<=max; j+=i){
        //         prime[j] = true;
        //     }
        // }

        // System.out.println(sb);
    }
}