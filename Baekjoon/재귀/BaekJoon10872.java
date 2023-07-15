package 재귀;

import java.util.Scanner;

public class BaekJoon10872 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int result = factorial(n);

        System.out.println(result);
    }

    public static int factorial(int n){
        if(n <= 1) return 1;
        
        return n * factorial(n-1);
    }
}
