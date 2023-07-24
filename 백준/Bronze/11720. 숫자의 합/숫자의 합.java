
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	 st = new StringTokenizer(bf.readLine());
    	String target = st.nextToken();
    	
    	int result = 0;
    	for(int i=0; i<n; i++) {
    		result += Integer.parseInt(target.split("")[i]);
    	}
    	
    	System.out.println(result);
    	
    
    }
}