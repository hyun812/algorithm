import java.util.Scanner;

/**
 * back2202
 */
public class BaekJoon2202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int range = 2;

        if(N == 1){
            System.out.println(1);
        }

        else{
            while(N >= range){
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    
    }
}