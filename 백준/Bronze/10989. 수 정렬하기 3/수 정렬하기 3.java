
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(bf.readLine());
    
        
        int[] arr = new int[n];
        
        
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(bf.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++) {
        	sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
         
    }

}


