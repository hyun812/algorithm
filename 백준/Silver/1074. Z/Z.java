import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int result;
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        n = (int)Math.pow(2, N);
        
        check(r, c, n);
        
        System.out.println(result);
    }
    
    
    
    public static void check(int r, int c, int length) {
//    	int len = length/2;
    	
    	if(length/2 < 1) return;
    	
    	if(r < length/2 && c < length/2) { // 왼쪽 위일때
    		
    		check(r,c,length/2);
    		
    	}else if(r < length/2 && c >= length/2) { // 오른쪽 위일때
    		
    		result += (length/2*length/2);
    		check(r,c-length/2,length/2);
    		
    	}else if(r >= length/2 && c < length/2) { // 왼쪽 아래일때
    		
    		result += (length/2*length/2*2);
    		check(r-length/2,c,length/2);
    		
    	}else if(r >= length/2 && c >= length/2) { // 오른쪽 아래일때
    		
    		result += (length/2*length/2*3);
    		check(r-length/2,c-length/2,length/2);
    		
    	}

    	
    	
    	
    }
}


