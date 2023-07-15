package 카카오2022;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem2 {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        int count =0;
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
                count++;
            }
        }
        System.out.println(count);

    }   
}
