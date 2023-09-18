import java.util.*;
import java.io.*;

public class Solution {
    static int n, m;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        for(int tc=1; tc<=t; tc++){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken()); // 정점의 개수
            m = Integer.parseInt(st.nextToken()); // 간선의 개수

            parents = new int[n+1];
            make();

            for(int i=0; i<m; i++){
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
            }

            // root찾아서 set에 넣기
            // 중복제거를 통해 무리가 몇갠지 확인 가능
            Set<Integer> set = new HashSet<>();
            for(int j=1; j<=n; j++){
                int root = find(j);
                set.add(root);
            }

            // set에 남아있는 무리의 개수
            System.out.println("#" + tc + " "+ set.size());
        }
    }

    private static void make(){
        for(int i=1; i<=n; i++){
            parents[i] = i;
        }
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    private static int find(int a){
        if(a == parents[a]) return a;
        else {
            int b = find(parents[a]);
            parents[a] = b;
            return b;
        }
    }
}