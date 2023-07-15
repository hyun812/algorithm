package 정렬;

import java.util.Scanner;

public class BaekJoon2750 {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        Sort(n);

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }

    public static void Sort(int n){
        int temp=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j]){
                   temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp; 
                }
            }
        }
    }
}
