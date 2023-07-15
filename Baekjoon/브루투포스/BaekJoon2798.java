package 브루투포스;

import java.util.Scanner;

public class BaekJoon2798 {
    static int[] arr;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int max = in.nextInt();

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();    
        }

        blackjack(n, max);
    }

    public static void blackjack(int n, int max){
        int result = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= max && result < sum){
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
