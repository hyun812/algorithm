import java.util.LinkedList;
import java.util.Deque;
import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
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
        return count;
    }
}