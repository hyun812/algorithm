
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        
       
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<m; i++){
            sum += arr[i];
        }
        int max = sum;
        int cnt = 1;
        
        for(int i=m; i<n; i++){
            sum -= arr[i-m];
            sum += arr[i];
            
            if(max < sum){
                max = sum;
                cnt = 1;
            }else if(max == sum){
                cnt++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }

    }
}