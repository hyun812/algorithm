import java.util.Scanner;

public class BaekJoon2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weight = sc.nextInt();

        for(int i=weight/5; i>=0; i--){
            int reweight = weight - (i*5);
            if(reweight % 3 ==0){
                System.out.println(i+(reweight/3));
                return;
            }
        }
        
        System.out.println(-1);
    }
}
