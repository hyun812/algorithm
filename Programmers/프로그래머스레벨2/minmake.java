
import java.util.Arrays;

//레벨2 - 최솟값 만들기
public class minmake {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int sum1 = 0;
        int sum2 = 0;

        int ind = A.length-1;
        for(int i=0; i<A.length; i++){
            sum1 += A[i] * B[ind-i];
        }

        System.out.println(sum1);
    }
}
