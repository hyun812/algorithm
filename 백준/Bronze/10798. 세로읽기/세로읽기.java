import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[][] arr = new String[5][15];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            for(int j=0; j<s.length(); j++){
                arr[i][j] = s.split("")[j];
            }
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] == null) continue;
                System.out.print(arr[j][i]);
            }
        }
        
    }
}