
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    static int n;
    static int m;
    static String[] arr;


    static int[] checkarr;
    static int[] myarr;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        
        st = new StringTokenizer(bf.readLine());
        arr = st.nextToken().split("");

        st = new StringTokenizer(bf.readLine());
        checkarr = new int[4];
        myarr = new int[4];

        for(int i=0; i<4; i++){
            checkarr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<m; i++){
            if(arr[i].equals("A")) myarr[0]++;
            if(arr[i].equals("C")) myarr[1]++;
            if(arr[i].equals("G")) myarr[2]++;
            if(arr[i].equals("T")) myarr[3]++;
        }

        if(check()) result++;

        for(int i=m; i<n; i++){
            int j = i - m;

            // 이전 부분문자열 제외
            if(arr[j].equals("A")) myarr[0]--;
            if(arr[j].equals("C")) myarr[1]--;
            if(arr[j].equals("G")) myarr[2]--;
            if(arr[j].equals("T")) myarr[3]--;     

            // 끝 문자열 추가
            if(arr[i].equals("A")) myarr[0]++;
            if(arr[i].equals("C")) myarr[1]++;
            if(arr[i].equals("G")) myarr[2]++;
            if(arr[i].equals("T")) myarr[3]++;

            if(check()) result++;
        }

        System.out.println(result);

    }

    
    private static boolean check(){
        for(int i=0; i<4; i++){
            if(checkarr[i] > myarr[i]){
                return false;
            }
        }

        return true;
    }
}