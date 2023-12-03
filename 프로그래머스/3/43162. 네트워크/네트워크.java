import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			bfs(i, computers, visited);
			answer++;
		}
        
        return answer;
    }
    
    public void bfs(int start, int[][] computers, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int poll = q.poll();

			for (int i = 0; i < computers[poll].length; i++) {
				if (poll == i)
					continue; // 자기자신이면
				if (computers[poll][i] == 0)
					continue; // 연결 안되어있으면
				if (visited[i])
					continue; // 이미 방문했으면

				q.offer(i);
				visited[i] = true;
			}
		}
    }
}