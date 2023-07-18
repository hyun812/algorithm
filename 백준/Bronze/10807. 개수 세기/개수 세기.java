import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * pratic
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int target = Integer.parseInt(st.nextToken());
        int result = 0;
        for(int i: arr){
          if(i == target){
            result++;
          }
        }

        System.out.println(result);
        

    }
}