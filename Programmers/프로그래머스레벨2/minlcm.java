
import java.util.Arrays;

//레벨2 - N개의 최소공배수
public class minlcm {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        Arrays.sort(arr);
        int answer = 0;

        if(arr.length == 1){
            answer = arr[0];
        }
        else if(arr.length == 2){
            answer = lcm(arr[arr.length-1], arr[arr.length-2]);
        }
        else{
            answer = lcm(arr[arr.length-1], arr[arr.length-2]);
            for(int i=arr.length-2; i>0; i--){
                answer = lcm(answer, arr[i]);
            }
        }
        System.out.println(answer);
    }

    public static int lcm(int a, int b){
        return (a*b) / gcd(a, b);
    }

    public static int gcd(int a, int b){
        int cal = 0;
        while(b != 0){
            cal = a % b;
            a = b;
            b = cal;
        }
        return a;
    }

}