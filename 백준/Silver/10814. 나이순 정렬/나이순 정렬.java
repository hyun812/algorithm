import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        String[][] arr = new String[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            arr[i][0] = a;
            arr[i][1] = b;
        }
        
        Arrays.sort(arr, (o1, o2) ->{
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        });

        for(int i=0; i<n; i++){
            System.out.println(arr[i][0]+ " " + arr[i][1]);
        }
    }
}
