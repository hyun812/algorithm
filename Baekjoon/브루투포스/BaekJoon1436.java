package 브루투포스;

import java.util.Scanner;

public class BaekJoon1436 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
        int num=666;
        int count =1;
        
        while(count != n){
            num++;

            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);
    }
}
