
import java.util.Deque;
import java.util.Arrays;
import java.util.LinkedList;

//레벨2 - 구명보트
public class lifeboat {
    public static void main(String[] args) {
        int[] people = {50, 50, 50, 50};
        int limit = 100;
        
        Arrays.sort(people);
        
        Deque<Integer> dq = new LinkedList<>();
        int count =0;

        for(int i : people){
            dq.add(i);
        }

        while(true){
            if(dq.isEmpty()){
                break;
            }
            
            if(dq.size() == 1){
                count++;
                break;
            }

            if(dq.getFirst() + dq.getLast() <= limit){
                dq.removeFirst();
                dq.removeLast();
                count++;
            }
            else {
                dq.removeLast();
                count++;
            }
        }
        
        System.out.println(count);
    }
}
 