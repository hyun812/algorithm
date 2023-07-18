import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int min = arr[0];
        int max = arr[0];

        for(int i=1; i<n; i++){
          if(min >= arr[i]){
            min = arr[i];
          }
          if(max <= arr[i]){
            max = arr[i];
          }
        }

        
        System.out.print(min + " " + max);
    }
}