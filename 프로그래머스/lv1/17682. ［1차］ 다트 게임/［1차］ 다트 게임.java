import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
Stack<Integer> stack = new Stack<>();

        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)){
                if((int)c - '0' == 1 && i+1<dartResult.length()-1 && dartResult.charAt(i+1)=='0'){
                    stack.push(10);
                    i++;                    
                }
                else{
                    stack.push((int)c - '0');
                }
            }
            else{
                int pre = stack.pop();
                if(c == 'D'){
                    pre = pre*pre;
                }
                else if(c == 'T'){
                    pre = pre*pre*pre;
                }
                else if(c == '*'){
                    if(!stack.isEmpty()){
                        int val = stack.pop() * 2;
                        stack.push(val);
                    }
                    pre = pre *2;
                }
                else if(c == '#'){
                    pre = pre * (-1);
                }
                stack.push(pre);
            }
        }
        int sumscore = 0;
        while(!stack.isEmpty()){
            sumscore += stack.pop();
        }
        return sumscore;
    }
}