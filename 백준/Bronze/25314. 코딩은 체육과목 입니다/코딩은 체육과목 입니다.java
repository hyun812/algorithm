import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	
    	for(int i=0; i<a/4; i++) {
    		System.out.print("long ");
    	}
    	
    	System.out.print("int");
    	
    }
}