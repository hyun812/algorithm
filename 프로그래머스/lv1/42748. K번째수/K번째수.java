import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
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
        return answer;
    }
}