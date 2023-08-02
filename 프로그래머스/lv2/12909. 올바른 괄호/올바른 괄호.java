import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
 Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char point = s.charAt(i);
            if(point == ')'){
                if(st.empty()){
                    answer = false;
                    break;
                }
                st.pop();
            }
            else{
                st.push(point);
            }
        }
        
        if(!st.empty()){
            answer = false;
        }

        return answer;
    }
}