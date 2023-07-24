
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	
    	String a = st.nextToken();
    	String b = st.nextToken();
    	
    	String result = "";
    	String ra = "";
    	String rb = "";
    	
    	for(int i=a.length()-1; i>=0; i--) {
    		ra += a.split("")[i];
    	}
    	
    	for(int i=b.length()-1; i>=0; i--) {
    		rb += b.split("")[i];
    	}
    	
    	result = (Integer.parseInt(ra) > Integer.parseInt(rb)) ? ra : rb;
    	System.out.println(result);
    }
}