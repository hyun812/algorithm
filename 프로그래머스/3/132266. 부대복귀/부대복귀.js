function solution(n, roads, sources, destination) {
    var answer = [];
    
    const graph = Array.from({ length: n + 1 }, () => []);
    for (const road of roads) {
        const [from, to] = road;
        graph[from].push(to);
        graph[to].push(from);
    }
    
    const dijkstra = () => {
        const queue = [[destination, 0]];
        const dist = Array(n + 1).fill(Infinity);
        
        dist[destination] = 0;
        
        while (queue.length) {
            const [cur, cost] = queue.shift();
            
            for (const next of graph[cur]) {
                if (dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    queue.push([next, dist[next] + 1]);
                }
            }
        }
        return dist;
    }
    
    const results = dijkstra();
    
    return sources.map(v => results[v] === Infinity ? -1 : results[v]);
}