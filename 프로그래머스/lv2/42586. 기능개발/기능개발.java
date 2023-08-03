import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>(); 
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0; i<progresses.length; i++){
      double re = (100-progresses[i])/(double) speeds[i];
      int day = (int) Math.ceil(re);

      if(!queue.isEmpty() && queue.peek() < day){
        list.add(queue.size());
        queue.clear();
      }

      queue.add(day);
    }
    list.add(queue.size());

    int[] answer = new int[list.size()];
    for(int i=0; i<list.size(); i++){
      answer[i] = list.get(i);
    }
        
        
        return answer;
    }
}