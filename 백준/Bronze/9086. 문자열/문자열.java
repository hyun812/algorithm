
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int T = Integer.parseInt(st.nextToken());
    	for(int i=1; i<=T; i++) {
    		st = new StringTokenizer(bf.readLine());
    		String target = st.nextToken();
    		String result = target.split("")[0] + target.split("")[target.length()-1]; 
    		System.out.println(result);	
    	}
    	
    	
    
    }
}