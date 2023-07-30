
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int sum = a+b+c;
		
		String s = "";
		if(sum == 180) {
			if(a==60 && b==60 && c==60) s="Equilateral";
			else if(a == b || b==c || a==c) {
				s="Isosceles";
			}else {
				s="Scalene";
			}
		}else {
			 s="Error";
		}
		
		System.out.println(s);
	}
}