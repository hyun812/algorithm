package 기본수학2;

import java.util.Scanner;

public class BaekJoon2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int min = sc.nextInt();
        int max = sc.nextInt();

        int sum = 0;
        int count = 0;
        int minnum = 0;
        for(int i=min; i<=max; i++){
            boolean istrue = true;

            if(i == 1){
                continue;
            }

            for(int j=2; j<i; j++){
                if(i % j == 0){
                    istrue = false;
                    break;
                }
            }

            if(istrue==true){
                if(count ==0){
                    minnum = i;
                    count++;
                }
                sum += i;
            }
        }
        
        if(sum ==0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(minnum);
        }
    }    
}

