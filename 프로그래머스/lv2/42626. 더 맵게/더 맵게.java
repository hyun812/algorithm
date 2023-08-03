import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            q.add(scoville[i]);
        }

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
        return answer;
    }
}