function solution(n, edge) {
    let answer = 0;
    let max = 0;
    
    const graph = Array.from({ length: n + 1 }, () => []);
    for (const [from, to] of edge) {
        graph[from].push(to)
        graph[to].push(from)
    }
    
    const bfs = () => {
        const queue = [[1, 0]];
        const visited = Array(n + 1).fill(0);
        
        visited[1] = 1;
        
        while (queue.length) {
            const [cur, len] = queue.shift();
            
            if (len > max) {
                max = len;
                answer = 1;
            } else if (len === max) {
                answer++;   
            }
            
            for (const next of graph[cur]) {
                if (visited[next]) continue;
                visited[next] = 1;
                queue.push([next, len + 1]);
            }
        }
    }
    
    bfs();
    
    return answer;
}