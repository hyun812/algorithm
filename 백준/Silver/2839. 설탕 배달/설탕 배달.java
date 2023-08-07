
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            
        int n = Integer.parseInt(bf.readLine());
        
        for(int i=n/5; i>=0; i--){
            int re = n - (i*5);
            if(re % 3 == 0){
                System.out.println(i+(re/3));
                return;
            }
        }

        System.out.println(-1);
    }


}