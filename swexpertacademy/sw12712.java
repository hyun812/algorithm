import java.io.*;
import java.util.*;

public class sw12712 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i=1; i<=T; i++){
            st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            for(int j=0; j<n; j++){
                st = new StringTokenizer(bf.readLine());
                for(int k=0; k<n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    int Psum = plusc(arr, x, y, m);
                    int Msum = mult(arr, x, y, m);
                    
                    result = (result < Psum) ? Psum : result;
                    result = (result < Msum) ? Msum : result;
                }
            }

            System.out.println("#"+i+" "+result);

        }
    }

    static public int plusc(int[][] arr, int x, int y, int m){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int sum = arr[x][y];
        
        for(int i=0; i<4; i++){
            for(int j=1; j<m; j++){
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if(nx < arr.length && nx >= 0 && ny < arr.length && ny >=0){
                    sum += arr[nx][ny];
                }
            }
        }
        
        
        return sum;
    }

    static public int mult(int[][] arr, int x, int y, int m){
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1};

        int sum = arr[x][y];
        
        for(int i=0; i<4; i++){
            for(int j=1; j<m; j++){
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if(nx < arr.length && nx >= 0 && ny < arr.length && ny >=0){
                    sum += arr[nx][ny];
                }
            }
        }
        

        return sum;
    }
    
}
