import java.util.Scanner;

public class BaekJoon1193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 2;
        int range = 1;
    
        if(N ==1){
            System.out.println("1/1");
        }
        else{
            while(N > range){
                range = range + cnt;
                cnt++;
            }
            int a = range-N;
            if(cnt % 2 == 0){
                System.out.println((a+1) + "/" + (cnt-1-a));
            }
            else if(cnt % 2 !=0){
                System.out.println((cnt-1-a) + "/" + (a+1));
            }
        }
    }
}
