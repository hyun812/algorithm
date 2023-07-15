import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class rotation {
    public static void main(String[] args) {
        String s = "[](){}";

        int answer = 0;
        int len = s.length();
        int x =0;
        Stack<Character> ck = new Stack<>();
        while(x!=len){
            ck.clear();
            for(int j=0; j<len; j++){
                Character target = s.charAt(j);
                if(ck.isEmpty()){
                    ck.push(target);
                }else{
                    if(target == ']'){
                        if(ck.peek() == '['){
                            ck.pop();
                        }
                        else{
                            ck.push(target);
                        }
                    } 
                    else if(target == ')'){
                        if(ck.peek() == '('){
                            ck.pop();
                        }
                        else{
                            ck.push(target);
                        }
                    } 
                    else if(target == '}'){
                        if(ck.peek() == '{'){
                            ck.pop();
                        }
                        else{
                            ck.push(target);
                        }
                    }
                    else{
                        ck.push(target);
                    }
                }
            }   
            if(ck.isEmpty()){
                answer++;
            }
            s = s.substring(1, len) + s.split("")[0];
            x++;
            
        }
        System.out.println(answer);
    }
}
