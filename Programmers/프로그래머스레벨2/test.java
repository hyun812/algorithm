import java.util.*;
import java.io.*;

/**
 * test
 */
public class test {

    public static void main(String[] args) throws Exception {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			Queue<String> Q = new LinkedList<>();
			Stack<String> sta = new Stack<>();
			Q.add(Q);
			
        Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int max = 0;
			for(int j=0; j<10; j++) {
				int num = sc.nextInt();
				if(max < num) {
					max = num;
				}
			}
			System.out.println("#"+(i+1)+ " "+max);
		}
    }
}