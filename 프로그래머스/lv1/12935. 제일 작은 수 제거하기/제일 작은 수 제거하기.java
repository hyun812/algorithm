import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        int[] answer;
        if(arr.length == 1){
            answer = new int[] {-1};
        }
        else{
            for(int i=0; i<arr.length; i++){
                if(arr[i] == min){
                    continue;
                }
                else{
                    al.add(arr[i]);
                }
            }

            answer = new int[al.size()];
            for(int i=0; i<al.size(); i++){
                answer[i] = al.get(i).intValue();
            }
            
        }
        return answer;
    }
}