
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pring {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i : priorities){
            queue.offer(i);
        }

        Arrays.sort(priorities);

        //2 1 3 2
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
        
        System.out.println(count);
    }
}
