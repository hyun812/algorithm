import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] nums;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        nums = new int[m];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        check(0);
        System.out.println(sb);
    }

    private static void check(int cnt){
       

        if(cnt == m){
            for(int i=0; i<nums.length; i++){
                sb.append(nums[i]);
                sb.append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            nums[cnt] = arr[i];
            check(cnt+1);
        }
    }

}
