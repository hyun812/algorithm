import java.util.ArrayList;
import java.util.StringTokenizer;

public class kcount {
  public static void main(String[] args) {
    int answer = 0;
    int n = 437674;
    int k = 3;

    String make = Integer.toString(n,k);
    System.out.println(make);
    StringTokenizer st1 = new StringTokenizer(make, "0");
    ArrayList<String> pstr = new ArrayList<String>();

    while(st1.hasMoreTokens()){
        pstr.add(st1.nextToken());
    }
    
    System.out.println(pstr);
    for(String num : pstr){
        boolean istrue = true;

        if(Long.parseLong(num) == 1){
            continue;
        }

        for(int j=2; j<Long.parseLong(num); j++){
            if(Long.parseLong(num) % j == 0){
                istrue = false;
                break;
            }
        }

        if(istrue==true){
            answer++;
        }
    }
    System.out.println(answer);
  }
}
