import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String aw = Integer.toString(n);
        
        char[] arr = aw.toCharArray();

        for(char i : arr){
            answer += Character.getNumericValue(i);
        }
            
    

        return answer;
    }
}