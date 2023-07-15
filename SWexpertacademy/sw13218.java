import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw13218 {
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=1; i<=T; i++){
      st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());

      System.out.println("#"+i+" " +N/3);
    }
  }
}
