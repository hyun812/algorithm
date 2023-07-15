package 프로그래머스레벨1;

import java.util.Arrays;
import java.util.HashMap;

// 레벨1 - K번째 수
public class Kindex {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
            if(commands[i][0] == commands[i][1]){
                answer[i] = array[commands[i][1]-1];
            }
            else{
                arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(arr);
                answer[i] = arr[commands[i][2]-1];
            }
            
        }
        
        System.out.println(Arrays.toString(answer));
    }
}
