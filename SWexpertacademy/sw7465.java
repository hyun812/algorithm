import java.util.*;
import java.io.*;
 
 
public class sw7465 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
 
        int T = Integer.parseInt(st.nextToken());
 
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            parent = new int[n+1];
            for(int i=1; i<=n; i++) {
                parent[i] = i;
            }
 
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(bf.readLine());
 
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
 
 
                union(a,b);
            }
             
            int result = 0;
            for(int i=1; i<=n; i++) {
                if(parent[i] == i) {
                    result++;
                }
            }
            System.out.println("#"+tc+" "+result);
 
        }
 
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if(x>y) parent[y]=  x;
        if(x<y) parent[x] = y;
    }
 
 
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    //  parent[x] = 
}