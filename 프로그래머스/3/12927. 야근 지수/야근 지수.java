import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for ( int work : works )
            pq.add( work );

        for( int i = 0 ; i < n; i++){
            int work = pq.poll();
            if ( work == 0 ) return 0; //가장 많이 남은 일이 0 //남은 일이 없다
            
            pq.add( work - 1 );
        }
    
        while (!pq.isEmpty()) {
            answer += (Math.pow( pq.poll(), 2));
        }
        return answer;
    }
}