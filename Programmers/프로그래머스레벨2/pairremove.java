
import java.util.Stack;

//레벨2 - 짝지어 제거하기
public class pairremove {
    public static void main(String[] args) {
        String s = "cdcd";
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

        System.out.println(answer);
    }
}
