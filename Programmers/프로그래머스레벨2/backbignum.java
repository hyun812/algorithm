import java.util.Arrays;
import java.util.Stack;

public class backbignum {
  public static void main(String[] args) {
    int[] numbers = {9,1,5,3,6,2};
    Stack<Integer> st = new Stack<>();

    int[] result = new int[numbers.length];
    
    Arrays.fill(result, -1);

    for(int i=0; i<numbers.length; i++){
      while(!st.isEmpty() && numbers[st.peek()] < numbers[i]){
        result[st.pop()] = numbers[i];
      }
      st.push(i);
    }

    System.out.println(Arrays.toString(result));
  }
}
