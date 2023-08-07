
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            hm.put(bf.readLine(), 0);
        }

        int cnt = 0;
        for(int i=0; i<m; i++){
            String check = bf.readLine();
            if(hm.containsKey(check)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }


}