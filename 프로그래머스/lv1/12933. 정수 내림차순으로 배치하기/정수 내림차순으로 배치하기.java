import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String answer = "";
        
        String s = Long.toString(n);
        String[] ss = s.split("");
        
        Arrays.sort(ss, Collections.reverseOrder());

        for(int i=0; i<ss.length; i++){
            answer += ss[i];    
        }
        
        return Long.parseLong(answer);
    }
}