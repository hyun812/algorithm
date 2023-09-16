import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        arr = new int[10][10];
        ans = Integer.MAX_VALUE;

        for(int i=0; i<10; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);

        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);
    }

    static int[] papaers = {0, 5, 5, 5, 5, 5};

    private static void dfs(int y, int x, int cnt){
        if(y >= 9 && x>9){
           ans = Math.min(ans, cnt);
           return;
        }

        // 이미 ans보다 크면 return
        if(cnt >= ans) return;

        if(x>9){
            dfs(y+1, 0, cnt);
            return;
        }

        if(arr[y][x] == 1){
            for(int i=5; i>=1; i--){
                if(papaers[i] > 0 && paperCheck(y, x, i)){ // 종이가 남아있고 붙힐수 있으면
                    fillArr(y,x,i,0); // 종이 붙이기
                    papaers[i]--;
                    dfs(y,x+1,cnt+1);
                    fillArr(y,x,i,1); // 종이 떼기
                    papaers[i]++;
                }
            }
        }
        else{
            dfs(y,x+1,cnt);
        }

    }

    private static void fillArr(int y, int x, int size, int fill){
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                arr[i][j] = fill;
            }
        }
    }

    private static boolean paperCheck(int y, int x, int size){
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(!outOfIdx(i, j)) return false; // 범위 벗어나면 false 리턴
                if(arr[i][j] == 0) return false; // 0이면 false 리턴
            }
        }
        return true;
    }

    private static boolean outOfIdx(int y, int x){
        if(y>=0 && y<10 && x>=0 && x<10){
            return true;
        }
        return false;
    }
}