import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	
    	
    	String s = "";
    	while(n > 0) {
    		
    		if(n%b < 10) {
    			s = (n%b) + s;
    		}else {
    			s = (char) (n%b + 'A' -10) + s;	
    		}
    		n = n/b;
    		
 
    	}
    	

    	System.out.println(s);
    	
    }
}