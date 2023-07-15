import java.util.*;

public class queuesum {
  public static void main(String[] args) {

    int answer = -2;

    int[] queue1 = {1,1};
    int[] queue2 = {1,5};

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    int sum1 = 0;
    int sum2 = 0;
    int count = 0;

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
        if(count == queue1.length*2){
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
          count++;
        }else if(sum1 < sum2){
          int target = q2.poll();
          sum1 += target;
          sum2 -= target;
          q1.add(target);
          count++;
        }
      }  
    }
    System.out.println(count);


  }
}
