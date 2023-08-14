
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());

        String s = bf.readLine();
        Integer[] arr = new Integer[s.length()];
        
        for(int i=0; i<s.length(); i++) {
        	arr[i] = Integer.parseInt(s.split("")[i]);
        }
        
        Arrays.sort(arr, (o1, o2) ->{
        	return o2-o1;
        });
        
        for(int i=0; i<s.length(); i++) {
        	sb.append(arr[i]);
        }
        System.out.println(sb.toString());
         
    }

}


