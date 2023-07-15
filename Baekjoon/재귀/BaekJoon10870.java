package 재귀;

import java.util.Scanner;

public class BaekJoon10870 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int result = Fibonacci(n);

        System.out.println(result);
    }


    public static int Fibonacci(int n){
        if(n==0) return 0;        
        if(n==1) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
