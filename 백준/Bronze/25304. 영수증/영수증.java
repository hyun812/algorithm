import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(bf.readLine());
    	int b = Integer.parseInt(st.nextToken());
    	
    	int sum = 0;
    	for(int i=0; i<b; i++) {
    		st = new StringTokenizer(bf.readLine());
    		int pri = Integer.parseInt(st.nextToken());
    		int cnt = Integer.parseInt(st.nextToken());
    		
    		sum += (pri*cnt);
    	}
    	
    	if(sum == a) {
    		System.out.println("Yes");	
    	}else {
    		System.out.println("No");
    	}
    	
    	
    	
    }
}