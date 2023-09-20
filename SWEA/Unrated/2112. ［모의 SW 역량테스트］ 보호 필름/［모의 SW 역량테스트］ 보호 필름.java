import java.io.*;
import java.util.*;

public class Solution {
    static int d, w, k;
    static int[][] arr, copyArr;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());
        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(bf.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[d][w];
            copyArr = new int[d][w];

            for(int i=0; i<d; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<w; j++){
                    int a = Integer.parseInt(st.nextToken());
                    arr[i][j] = a;
                    copyArr[i][j] = a;
                }
            }

            for(int i=0; i<d; i++){
                if(doIt(0, 0, i)){
                    ans = i;
                    break;
                }
                copy();
            }
            System.out.println("#"+tc+" "+ans);
        }
    }

    private static boolean doIt(int idx, int k, int drugCnt){
        if(k == drugCnt){
            return checkArr(drugCnt);
        }

        for(int i=idx; i<d; i++){ // 몇번째 줄에 약을 투입할지
            for(int j=0; j<2; j++){ // 어떤 타입에 약을 투입할지
                addType(i,j);
                if(doIt(i+1, k+1, drugCnt)) return true;
                delType(i);
            }
        }
        return false;
    }

    private static void addType(int x, int type){
        for(int i=0; i<w; i++){
            copyArr[x][i] = type;
        }
    }

    private static void delType(int x){
        for(int i=0; i<w; i++){
            copyArr[x][i] = arr[x][i];
        }
    }

    private static boolean checkArr(int a) {
        for (int j = 0; j < w; j++) {
            int cnt = 1;
            boolean flag = false;
            for (int i = 0; i < d-1; i++) {
                if(copyArr[i][j]==copyArr[i+1][j]) cnt++;
                else cnt = 1;

                if(cnt == k) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    private static void copy(){
        for(int i=0; i<d; i++){
            for(int j=0; j<w; j++){
                copyArr[i][j] = arr[i][j];
            }
        }
    }
}