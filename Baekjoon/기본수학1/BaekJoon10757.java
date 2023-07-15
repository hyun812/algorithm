import java.math.BigInteger;
import java.util.Scanner;

public class BaekJoon10757 {
    // BigInteger 사용
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);

    //     BigInteger A = new BigInteger(sc.next());
    //     BigInteger B = new BigInteger(sc.next());

    //     A = A.add(B);

    //     System.out.println(A);
    // }

    // 직접 덧셈 구현
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str_A = sc.next();
        String str_B = sc.next();

        int max_length = Math.max(str_A.length(), str_B.length());

        int[] A = new int[max_length+1];
        int[] B = new int[max_length+1];

        //A초기화
        for(int i= str_A.length()-1, idx=0; i>=0; i--, idx++){
            A[idx] = str_A.charAt(i) - '0'; // 맨뒤부터 역순으로 저장
        }

        //B초기화
        for(int i= str_B.length()-1, idx=0; i>=0; i--, idx++){
            B[idx] = str_B.charAt(i) - '0';
        }

        //덧셈
        for(int i=0; i<max_length; i++){
            int value = A[i] + B[i];
            A[i] = value%10;
            A[i+1] += value/10;
        }

        StringBuilder sb = new StringBuilder();
        if(A[max_length] !=0){
            sb.append(A[max_length]);
        }
        for(int i=max_length-1; i>=0; i--){
            sb.append(A[i]);
        }
        System.out.println(sb);
    }
}
