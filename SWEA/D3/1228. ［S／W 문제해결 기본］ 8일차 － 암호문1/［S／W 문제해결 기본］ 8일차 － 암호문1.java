
import java.util.*;
import java.io.*;

class Solution
{
  

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int tc =1; tc<=10; tc++){
            int n = Integer.parseInt(bf.readLine());
            LinkedList<Integer> pw = new LinkedList<Integer>();

            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; i++){
                pw.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<m; i++){
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for(int j=0; j< y; j++){
                    pw.add(x, Integer.parseInt(st.nextToken()));
                    x++;
                }
            }
            
            sb.append("#").append(tc).append(" ");
            for(int i=0; i<10; i++){
                sb.append(pw.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        

    }
}