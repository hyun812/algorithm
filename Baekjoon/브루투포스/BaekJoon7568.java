package 브루투포스;

import java.util.Scanner;

public class BaekJoon7568 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++){
            arr[i][0] = in.nextInt(); //몸무게
            arr[i][1] = in.nextInt(); //키
        }


        for(int i=0; i<n; i++){
            arr[i][2] = 1;
            
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    arr[i][2]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i][2] + " ");
        }
    }
}
