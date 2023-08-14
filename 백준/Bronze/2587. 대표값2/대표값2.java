
import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[5];
        int sum = 0;
        
        for(int i=0; i<5; i++) {
        	int num = Integer.parseInt(bf.readLine());
        	arr[i] = num;
        	sum += num;
        }
        
        Arrays.sort(arr);
        
        System.out.println(sum/5);
        System.out.println(arr[2]);
         
    }

}


