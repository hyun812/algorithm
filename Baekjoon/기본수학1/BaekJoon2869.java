import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int move = up-down;
        int safe_len = length - up;

        if(safe_len == 0){
            System.out.println(1);
            return;
        }

        int day = safe_len/move;
        if(day * move + up >= length){
            day = day + 1;
        }
        else{
            day = day +2;
        }
        System.out.println(day);
    }
}
