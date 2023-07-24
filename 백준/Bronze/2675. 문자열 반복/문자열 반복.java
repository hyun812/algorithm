import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int T = Integer.parseInt(st.nextToken());
    	for(int i=1; i<=T; i++) {
    		st = new StringTokenizer(bf.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		String a = st.nextToken();
    		
    		String result = "";
    		for(int j=0; j<a.length(); j++) {
    			for(int k=0; k<n; k++) {
    				result += a.split("")[j];
    			}
    		}
    		System.out.println(result);
    	}
    	
    	
    }
}