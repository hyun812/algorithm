
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static boolean[][] visited;
	static boolean[] isSelected;
	static int[] selectC;
	static int n;
	static int m;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int mindis = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		selectC = new int[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					chicken.add(new int[] { i, j });
				} else if (num == 1) {
					house.add(new int[] { i, j });
				}

				arr[i][j] = num;
			}
		}

		isSelected = new boolean[chicken.size()];

		com(0, 0);
		
		System.out.println(mindis);
	}

	public static void com(int cnt, int start) {
		if (m == cnt) {
			int result = 0;

			for(int i=0; i<house.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j<selectC.length; j++) {
					int dis = Math.abs(house.get(i)[0] - chicken.get(selectC[j])[0])+ Math.abs(house.get(i)[1] - chicken.get(selectC[j])[1]);
					
					temp = Math.min(temp, dis);
				}
				result += temp;
			}
			mindis = Math.min(mindis, result);
			
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			selectC[cnt] = i;
			com(cnt + 1, i + 1);

		}

	}
}
