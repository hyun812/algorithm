const bfs = (n, arr) => {
    const queue = [1];
    let visited = new Array(n+1).fill(0);
    
    visited[1] = 1;
    
    while(queue.length){
        const cur = queue.shift();

        for(const next of arr[cur]){
            if(visited[next]) continue;

            visited[next] = visited[cur] + 1;
            queue.push(next);
        }
    }
    
    return visited;
}

function solution(n, edge) {
    let answer = 0;
    
    const arr = new Array(n+1).fill().map(_ => []);
    
    for(const e of edge){
        arr[e[0]].push(e[1]);
        arr[e[1]].push(e[0]);
    }    
    
    const visited = bfs(n, arr);
    const max = Math.max(...visited);
    
    return visited.filter(el => el === max).length;
}