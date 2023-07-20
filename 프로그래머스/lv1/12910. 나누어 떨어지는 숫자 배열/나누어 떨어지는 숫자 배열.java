import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor ==0){
                set.add(arr[i]);
            }
        }

        int[] answer = new int[set.size()];

        if(set.isEmpty()){
            answer = new int[] {-1};
        }
        else{
            Iterator<Integer> iter = set.iterator();

            for(int i=0; i<set.size(); i++){
                answer[i] = iter.next();
            }
        }

        
        Arrays.sort(answer);
        return answer;
    }
}