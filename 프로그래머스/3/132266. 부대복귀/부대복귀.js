function solution(n, roads, sources, destination) {
    var answer = [];
    
    const road = new Array(n+1).fill().map(_ => []);
    roads.forEach((r) => {
        road[r[0]].push(r[1]);
        road[r[1]].push(r[0]);
    })
    
    const visited = new Array(n+1).fill(Infinity);
    
    const bfs = (source) => {
        const queue = [source];
        
        visited[source] = 0;
        
        while(queue.length){
            const cur = queue.shift();
            
            for(let i=0; i<road[cur].length; i++){
                const next = road[cur][i];
                
                if(visited[cur] + 1 < visited[next]){
                    visited[next] = visited[cur] + 1;
                    queue.push(next);   
                }
            }
        }
    }
    
    bfs(destination); // 목적지로부터 각각의 최단거리 구하기
    
    sources.forEach((source) => {
        const time = visited[source] === Infinity ? -1 : visited[source]       
        answer.push(time);
    })
    
    
          
    return answer;
}