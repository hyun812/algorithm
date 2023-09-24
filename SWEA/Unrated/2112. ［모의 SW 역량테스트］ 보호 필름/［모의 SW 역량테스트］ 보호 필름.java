import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static int res;
    static int d,w,k;  // 두께 D, 가로크기 W, 합격기준 K
    static int[][] map;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());

        for(int t =  1; t <= tc; t++) {
            st = new StringTokenizer(bf.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[d][w];
            res = d;

            for(int i=0; i<d; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            arr = new int[d];
            Arrays.fill(arr, -1); // -1로 채우기

            dfs(0,0);
            System.out.println("#"+ t + " " + res);
        }

    }
    static void dfs(int idx, int cnt) {
        if(cnt >= res){
            return;
        }

        if(idx == d){
            if(check()){
                res = Math.min(res,cnt);
            }
            return;
        }

        arr[idx] = -1;
        dfs(idx+1, cnt);

        arr[idx] = 0;
        dfs(idx+1, cnt+1);

        arr[idx] = 1;
        dfs(idx+1, cnt+1);
    }

    private static boolean check() { // 성능 검사
        int cnt;
        int a, b;
        for(int i=0; i<w; i++){
            cnt = 1;
            for(int j=0; j<d-1; j++){
                a = map[j][i];
                b = map[j+1][i];

                if(arr[j] != -1){
                    a = arr[j];
                }
                if(arr[j+1] != -1){
                    b = arr[j+1];
                }

                if(a == b){
                    cnt++;
                }else{
                    cnt = 1;
                }

                if(cnt == k){
                    break;
                }


            }
            if(cnt < k) return false;
        }
        return true;
    }
}
