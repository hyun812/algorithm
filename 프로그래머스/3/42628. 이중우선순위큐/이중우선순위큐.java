import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> minQ = new PriorityQueue<>();
		
		for(int i=0; i<operations.length; i++) {
			String order = operations[i].split(" ")[0];
			int num = Integer.parseInt(operations[i].split(" ")[1]);
			
			if(order.equals("I")) { // 주어진값 삽입
				minQ.offer(num);
				maxQ.offer(num);
			}else {
				if(maxQ.isEmpty() && minQ.isEmpty()) continue;
				if(num == 1) { // 최댓값 삭제
					int target = maxQ.poll();
					minQ.remove(target);
				}else if(num == -1) { // 최솟값 삭제
					int target = minQ.poll();
					maxQ.remove(target);
				}
			}
		}
		
		answer[0] = maxQ.isEmpty() ? 0 : maxQ.poll();
		answer[1] = minQ.isEmpty() ? 0 : minQ.poll();
        
        
        return answer;
    }
}