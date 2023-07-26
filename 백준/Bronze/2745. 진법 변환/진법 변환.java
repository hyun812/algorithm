import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	String s = st.nextToken();
    	int mul = Integer.parseInt(st.nextToken());
    	
    	int n = 1;
    	int result = 0;
    	
    	
    	for(int i=s.length()-1; i>=0; i--) {
    		char c = s.charAt(i);
    		int a = 0;
    		if('A' <= c && c <= 'Z') {
    			a = (s.charAt(i)-'A'+10);
    		}
    		else {
    			a = c-'0';
    		}
    		
    		result += a*n;
    		n *= mul;
    	}
    	
    	System.out.println(result);
    }
}