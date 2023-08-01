import java.io.*;
import java.util.*;

public class Main {

//	x+3y = -1;
//	4x+y = 7;
//
//
//	4x+12y = -12

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int x = 0;
		int y = 0;
		
		
//		a*d + b*d = c*d;
//		d*a + e*a = f*a;
		
		y = ((c*d) - (f*a))/((b*d)-(e*a));
		x = ((c*e) - (f*b))/((a*e)-(d*b));
		
//		a*e + b*e = c*e;
//		d*b + e*b = f*b;
//		
//		(a*e) x - (d*b)x = (c*e - f*b)
		
		System.out.println(x+ " " + y);
    }
}
