package 기본수학2;

import java.util.Scanner;

public class BaekJoon1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int count = 0;

        for(int i=0; i<N; i++){

            int num = sc.nextInt();
            boolean istrue = true;

            if(num == 1){
                continue;
            }

            for(int j=2; j<num; j++){
                if(num % j == 0){
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
