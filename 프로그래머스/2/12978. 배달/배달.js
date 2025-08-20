function solution(N, road, K) {
    const graph = Array.from({ length: N + 1 }, () => []);
    for (let i = 0; i < road.length; i++) {
        const [s, e, cost] = road[i];        
        graph[s].push([e, cost]);
        graph[e].push([s, cost]);
    }
    
    const dijkstra = () => {
        const queue = [[1, 0]];
        const dist = Array(N + 1).fill(Infinity);
        dist[1] = 0;
        
        while (queue.length) {
            const [cur, cost] = queue.shift();
            
            for (const [next, nextCost] of graph[cur]) {
                if (dist[next] > dist[cur] + nextCost) {
                    dist[next] = dist[cur] + nextCost;
                    queue.push([next, dist[next]]);
                }
            } 
        }
        
        return dist;
    }
    const dist = dijkstra();
    
    return dist.filter(v => v <= K).length;
}