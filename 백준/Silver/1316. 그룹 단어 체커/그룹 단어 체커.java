
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
		int result = n;
		
        for (int i = 0; i < n; i++) {
            boolean[] arr = new boolean[26];
            String s = br.readLine();
            
            for(int j=0; j<s.length()-1; j++) {
        		if(s.charAt(j) != s.charAt(j+1)) {
        			if(arr[s.charAt(j+1)-'a'] == true) {
        				result--;
        				break;
        			}
				}
        		arr[s.charAt(j)-'a'] = true;
        	}
        }
        System.out.println(result);
	}
}