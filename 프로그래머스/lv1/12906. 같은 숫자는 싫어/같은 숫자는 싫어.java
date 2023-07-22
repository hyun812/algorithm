import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]){
                al.add(arr[i]);
            }
        }

        int[] answer = new int[al.size()];

        for(int i=0; i<al.size(); i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
}