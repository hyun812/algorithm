import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] origin = new int[n];
        int[] sorted = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            origin[i] = sorted[i] = a;
        }
        
        Arrays.sort(sorted);
        int cnt = 0;

        for(int value : sorted){
            if(!hm.containsKey(value)){
                hm.put(value, cnt);
                cnt++;
            }
        }

        for(int i=0; i<origin.length; i++){
            sb.append(hm.get(origin[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
