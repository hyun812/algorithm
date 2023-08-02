import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> remove = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char point = s.charAt(i);
            if(remove.empty()){
                remove.push(point);
            }
            else{
                char target = remove.peek();
                if(point == target){
                    remove.pop();
                }
                else{
                    remove.push(point);
                }
            }
        }

        if(remove.empty()){
            answer = 1;
        }
        else{
            answer = 0;
        }

        return answer;
    }
}