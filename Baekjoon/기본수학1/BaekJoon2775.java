import java.util.Scanner;

public class BaekJoon2775 {

    public static int[][] APT = new int[15][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        create_APT();

        for(int i=0; i<T; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(APT[k][n]);
        }
    }

    public static void create_APT() {
        for(int i=0; i<15; i++){
            APT[i][1] = 1;
            APT[0][i] = i;
        }

        for(int i=1; i<15; i++){
            for(int j=2; j<15; j++){
                APT[i][j] = APT[i-1][j] + APT[i][j-1];
            }
        }
    }
}
