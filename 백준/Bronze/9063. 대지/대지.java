
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int minx = 99999;
		int maxx = -99999;
		int miny = 99999;
		int maxy = -99999;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			minx = (minx > x) ? x : minx;
			maxx = (maxx < x) ? x : maxx;
			miny = (miny > y) ? y : miny;
			maxy = (maxy < y) ? y : maxy;
		}
		
		int result = (maxx - minx) * (maxy-miny);
		System.out.println(result);
	}
}