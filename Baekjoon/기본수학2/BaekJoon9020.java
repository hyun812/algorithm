package 기본수학2;

import java.util.Scanner;

public class BaekJoon9020 {
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        get_prime();

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int n = sc.nextInt();

            for(int j=n/2; j>=2; j--){
                if(prime[j] == false && prime[n-j] == false){
                    System.out.println(j + " " + (n-j));
                    break;
                }
            }
        }
    }

    public static void get_prime(){
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++){
            if(prime[i]) continue;

            for(int j=i*i; j<prime.length; j+=i){
                prime[j] = true;
            }
        }
    }
}
