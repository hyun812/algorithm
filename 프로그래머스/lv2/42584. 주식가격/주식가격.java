import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

    Stack<Integer> st = new Stack<>();

    for(int i=0; i<prices.length; i++){
      while(!st.isEmpty() && prices[st.peek()] > prices[i]){
        int count = st.pop();
        result[count] = i-count;
      }
      st.push(i);
    }
    int idx = prices.length-1;
    while(!st.isEmpty()){
      int count = st.pop();
      result[count] = idx-count;
      
    }
        return result;
    }
}