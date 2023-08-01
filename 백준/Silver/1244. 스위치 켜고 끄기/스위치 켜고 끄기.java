import java.io.*;
import java.util.*;

/**
 * Main
 */

 // 1켜져있음 0 꺼져있음
 //
public class Main {
    static ArrayList<int[]> steps;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int len = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[len];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<len; i++){
            if(st.nextToken().equals("0")){
                arr[i] = false;
            }else{
                arr[i] = true;
            }
            
        }

        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int sw = Integer.parseInt(st.nextToken());

            if(gender == 1){ // 남학생
                for(int j=0; j<len; j++){
                    if((j+1)%sw == 0){
                        arr[j] = !arr[j];
                    }
                }
            }else{ // 여학생
                int idx = sw-1;
                int cnt = 1;
                arr[idx] = !arr[idx];
                while(idx-cnt >= 0 && idx+cnt < len){
                    if(arr[idx-cnt] == arr[idx+cnt]){
                        arr[idx-cnt] = !arr[idx-cnt];
                        arr[idx+cnt] = !arr[idx+cnt];
                    }else{
                        break;
                    }
                    cnt++;
                }
            }
        }

        for(int i=0; i<len; i++){
            if(i>19 && i%20 ==0){
                System.out.println();
            }

            if(arr[i]){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
            
        }

    }   
}