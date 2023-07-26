import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	int result = 0;
    	if(a==b && a==c && b==c) {
    		result = (a*1000) + 10000;
    	}else if(a==b) {
    		result = (a*100) + 1000;
    	}else if(a==c) {
    		result = (a*100) + 1000;
    	}else if(b==c) {
    		result = (b*100) + 1000;
    	}else {
    		int max = Math.max(a, Math.max(b, c));
    		result = 100*max;
    	}
    	
    	
    	System.out.println(result);
    }
}