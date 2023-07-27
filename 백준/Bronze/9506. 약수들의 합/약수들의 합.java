import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a;
		while(true) {
			a = Integer.parseInt(br.readLine());
			if(a == -1) break;
			int sum = 0;
			for(int i=1; i< a; i++) {
				if(a%i ==0) sum+=i;
			}
			
			if(a == sum) {
				System.out.print(a + " = ");
				System.out.print("1");
				for(int i=2; i< a; i++) {
					if(a%i ==0) {
						System.out.print(" + " + i);
					}
				}	
			}else {
				System.out.print(a + " is NOT perfect.");
			}
			System.out.println();
		}
		
		
	}
}