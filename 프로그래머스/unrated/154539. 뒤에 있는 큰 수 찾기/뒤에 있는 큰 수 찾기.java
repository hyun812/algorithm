import java.util.Arrays;
import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
    
    Stack<Integer> st = new Stack<>();

    int[] result = new int[numbers.length];
    
    Arrays.fill(result, -1);

    for(int i=0; i<numbers.length; i++){
      while(!st.isEmpty() && numbers[st.peek()] < numbers[i]){
        result[st.pop()] = numbers[i];
      }
      st.push(i);
    }

        return result;
    }
}