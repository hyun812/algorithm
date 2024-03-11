import java.io.*;
import java.util.*;

public class Main {
	static int m, n;
	static int[][] origin, arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		/*
		 * M개의 우주가 있고 각 우주에는 번호가 매겨진 N개의 행성이 있음 행성의 크기를 알때 균등한 우주의 쌍이 몇개인지
		 * 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 센다
		 */
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		origin = new int[m][n]; // 원본 배열
		arr = new int[m][n]; // 압축 배열
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = origin[i][j];
			}
		}
		
		for(int i=0; i<m; i++) {
			Arrays.sort(arr[i]);
		}
		
		for(int i=0; i<m; i++) {
			
			HashMap<Integer, Integer> hm = new HashMap<>();
			int lank = 0;
			
			hm.put(arr[i][0], 0);
			for(int j=1; j<n; j++) {
				if(origin[i][j-1] == origin[i][j]) {
					hm.put(arr[i][j], lank);
				}else {
					hm.put(arr[i][j], ++lank);
				}
			}
			
			for(int j=0; j<n; j++) {
				int temp = hm.get(origin[i][j]);
				origin[i][j] = temp; 
			}
		}
		
		
		for(int i=0; i<m-1; i++) {
			
			for(int j=i+1; j<m; j++) {
				if(Arrays.equals(origin[i], origin[j])) {
					answer++;
				}
			}
		}

		
		System.out.println(answer);

	}
}