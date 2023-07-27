
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int tc=1; tc<=T; tc++) {
			int a = Integer.parseInt(br.readLine());
			
			int i = a/25;
			int j = a%25;
			System.out.print(i + " ");
			
			i = j/10;
			j = j%10;
			System.out.print(i + " ");
			
			i = j/5;
			j = j%5;
			System.out.print(i + " ");
			
			j/=1;
			System.out.print(j + " ");

			System.out.println();
		}
		
	}
}