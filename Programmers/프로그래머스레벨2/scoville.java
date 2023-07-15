import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class scoville {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            q.add(scoville[i]);
        }
        System.out.println(q);

        while(true){
            if(q.peek() >=K){
                break;
            }
            if(q.size() == 1){
                answer = -1;
                break;
            }

            int a = q.poll();
            int b = q.poll();

            q.add(a+(b*2));
            answer++;
        }
        
        System.out.println(answer);
        
    }
}
