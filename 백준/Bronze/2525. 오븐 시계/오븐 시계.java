import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	int hour = Integer.parseInt(st.nextToken());
    	int minute = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(bf.readLine());
    	minute += Integer.parseInt(st.nextToken());
    	
    	while(true) {
    		if(minute < 60) {
    			break;
    		}
    		minute -= 60;
    		hour += 1;
    	}
    	
    	while(true) {
    		if(hour < 24) {
    			break;
    		}
    		hour -= 24;
    	}
    	
    	System.out.println(hour + " " + minute);
    }
}