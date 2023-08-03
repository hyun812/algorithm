import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i : priorities){
            queue.offer(i);
        }

        Arrays.sort(priorities);

        int position = priorities.length-1;
        int count = 0;
        while(!queue.isEmpty()){
            int target = queue.peek();

            if(target < priorities[position]){
                if(location == 0){
                    location = queue.size()-1;
                }
                else{
                    location--;
                }
                queue.offer(queue.poll());    
            }
            else{
                if(location == 0){
                    count++;
                    break;
                }
                else{
                    position = position-1;
                    location--;
                    count++;
                    queue.poll();
                }
                
            }
        }
        answer = count;
        return answer;
    }
}