import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[][] taste;
    static boolean[] isSelected;
    static int n;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());

            taste = new int[n][n];
            isSelected = new boolean[n];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    taste[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            check(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");

        }
        System.out.println(sb.toString());
    }

    public static void check(int cnt, int idx) {
        if (cnt == n/2) {
            check2();

            return;
        }

        for (int i = idx; i < n; i++) {
            isSelected[i] = true;
            check(cnt + 1, i+1);
            isSelected[i] = false;
            
        }
    }

    public static void check2() {
        int x=0;
		int y=0;

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;

				if(isSelected[i] && isSelected[j]) {
					x+=taste[i][j];
				}
                
				else if(!isSelected[i] && !isSelected[j]){
					y+=taste[i][j];
				}
			}
		}

        min = (min > Math.abs(x-y)) ? Math.abs(x-y) : min;
    }
}
         