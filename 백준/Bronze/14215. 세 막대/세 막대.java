
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int max = Math.max(a, Math.max(b, c));
		int result = 0;	
		
		if (max == a && max >= b + c) {
			result = b+c+b+c-1;
		}else if(max == b && max >= a + c) {
			result = a+c+a+c-1;
		}else if(max == c && max >= b + a) {
			result = b+a+b+a-1;
		}else {
			result = a+b+c;
		}
		
		System.out.println(result);

	}
}