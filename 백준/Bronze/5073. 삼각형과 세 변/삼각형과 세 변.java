import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = "";
		while (true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int max = Math.max(a, Math.max(b, c));
			if (a == 0 && b == 0 && c == 0)
				break;

			if (max >= b + c || max >= a + c || max >= a + b) {
				System.out.println("Invalid");
			}else {
				if (a == b && b == c && c == a)
					System.out.println("Equilateral");
				else if (a == b || b == c || a == c)
					System.out.println("Isosceles");
				else
					System.out.println("Scalene");
			}

		}

	}
}