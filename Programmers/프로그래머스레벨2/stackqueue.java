
import java.util.Stack;

//레벨2 - 올바른 괄호
public class stackqueue {
    public static void main(String[] args) {
        String s = "(())()";
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
        
        System.out.println(answer);
    }
}
