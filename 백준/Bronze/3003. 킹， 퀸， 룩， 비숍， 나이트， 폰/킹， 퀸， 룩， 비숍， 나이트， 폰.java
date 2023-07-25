import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	int[] orignal = {1, 1, 2, 2, 2, 8};
    	
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	for(int i=0; i<6; i++) {
    		int result = orignal[i]-Integer.parseInt(st.nextToken());
    		System.out.print(result + " ");
    	}
    	
    	
    }
}