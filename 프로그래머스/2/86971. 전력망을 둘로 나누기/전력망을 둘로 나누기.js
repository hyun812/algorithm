function solution(n, wires) {
    let answer = Number.MAX_SAFE_INTEGER;
    const arr = Array.from(Array(n+1), ()=>[]);
    
    wires.forEach((value) => {
        const [a, b] = value;
        arr[a].push(b);
        arr[b].push(a);
    })
    
    const bfs = (a, b) => {
        let cnt = 0;
        const queue = [];
        const visited = Array(n+1);
        
        visited[a] = 1;
        queue.push(a);
        
        while(queue.length){
            const cur = queue.shift();
            
            arr[cur].forEach((next) => {
                
                if(!visited[next] && next !== b){
                    visited[next] = 1;
                    queue.push(next);
                    cnt++;
                }
            })
        }
        return cnt;
    }
    
    wires.forEach((value) => {
        let [a, b] = value;
        
        answer = Math.min(answer, Math.abs(bfs(a, b) - bfs(b, a)));
    })
    
    return answer;
}