import java.util.Scanner;

public class BaekJoon11729 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        sb.append((int) (Math.pow(2, n) - 1)).append('\n');

        hanoi(1, 2, 3, n);
        

        System.out.print(sb);
    }

    public static void hanoi(int start, int mid, int end, int n){
        if(n==1){
            sb.append(start + " " + end+"\n");
            return;
        }
        
        hanoi(start, end, mid, n-1);
        sb.append(start + " " + end+"\n");
        hanoi(mid, start, end, n-1);
    }
}