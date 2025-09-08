function solution(n, wires) {
    let answer = Infinity;
    
    // 하나를 끊었을 때 2개로 나눠지는지
    // 2개로 나누어진다면 그 차이가 최소가 되도록
    const graph = Array.from({ length: n + 1}, () => []);
    for (const wire of wires) {
        const [from, to] = wire;
        graph[from].push(to);
        graph[to].push(from);
    }
    
    const bfs = (start, cutNode) => {
        const queue = [];
        const visited = Array(n + 1).fill(0);
        let count = 1;
        
        queue.push([start]);
        visited[start] = 1;
        while (queue.length) {
            const cur = queue.shift();
            
            for (const next of graph[cur]) {
                if (visited[next]) continue;
                if (next === cutNode) continue;
                visited[next] = 1;
                queue.push([next]);
                count++;
            }
        }
        
        return count;
    }
    
    for (const wire of wires) {
        const result1 = bfs(wire[0], wire[1]);
        const result2 = bfs(wire[1], wire[0]);
        answer = Math.min(Math.abs(bfs(wire[0], wire[1]) - bfs(wire[1], wire[0])), answer);
    }
    
    
    return answer;
}