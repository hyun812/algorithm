package 브루투포스;

import java.util.Scanner;

public class BaekJoon2231 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int result=0;

        for(int i=0; i<n; i++){
            int sum=0;
            int number=i;

            while(number !=0){
                sum += number%10;
                number /= 10;
            }

            if(sum+i == n){
                result = i;
                break;
            }
        }

        // for(int i=0; i<n; i++){
        //     result = i + i/1000000 + (i%1000000)/100000 + (i%100000)/10000 + (i%10000)/1000 + (i%1000)/100 + (i%100)/10 + (i%10);

        //     if(result == n){
        //         System.out.println(i);
        //         return;
        //     }
        // }

        System.out.println(result);
        return;
        
    }
}
