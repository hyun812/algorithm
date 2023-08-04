import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    long sum1 = 0;
    long sum2 = 0;

    for(int i=0; i<queue1.length; i++){
      q1.add(queue1[i]);
      sum1 += queue1[i];
    }

    for(int i=0; i<queue2.length; i++){
      q2.add(queue2[i]);
      sum2 += queue2[i];
    }

    if((sum1+sum2) %2 != 0) answer = -1;
    else{
      while(true){
        if(answer == queue1.length*4){
          answer = -1;
          break;
        }
        if(sum1 == sum2){
          break;
        }else if(sum1 > sum2){
          int target = q1.poll();
          sum1 -= target;
          sum2 += target;
          q2.add(target);
          answer++;
        }else if(sum1 < sum2){
          int target = q2.poll();
          sum1 += target;
          sum2 -= target;
          q1.add(target);
          answer++;
        }
      }  
    }
        return answer;
    }
}