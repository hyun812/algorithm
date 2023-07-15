import java.util.*;

public class progresses {
  public static void main(String[] args) {
    int[] progresses = {95, 90, 99, 99, 80, 99};
    int[] speeds = {1, 1, 1, 1, 1, 1};

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
    // int index = 0;
    // int target = queue.poll();
    // list.add(1);
    // while(queue.size() >= 1){
    //   int next = queue.peek();
      
    //   if(target >= next){
    //     list.set(index, list.get(index)+1);
    //     queue.remove();
    //   }
    //   else{
    //     index += 1;
    //     list.add(index, 1);
    //     target = next;
    //     queue.remove();
    //   }
    // }

    int[] answer = new int[list.size()];
    for(int i=0; i<list.size(); i++){
      answer[i] = list.get(i);
    }
    System.out.println(list);
    System.out.println(Arrays.toString(answer));
  }
}
