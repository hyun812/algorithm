import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] a = new int[9][9];
		int max = 0;
		int x = 0;
		int y = 0;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<9; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(max < a[i][j]) {
					max = a[i][j];
					x=i;
					y=j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println((x+1) + " " + (y+1));
	}

}


