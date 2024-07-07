/*
    n: 선수의 수
    results: 경기 결과를 담은 2차원 배열
*/
function solution(n, results) {
    let answer = 0; // 정확하게 순위를 매길 수 있는 선수
    
    const win = Array.from({length: n+1}, ()=>[]);
    const lose = Array.from({length: n+1}, ()=>[]);
    
    results.forEach((result) => {
        const [w, l] = result;
        
        win[w].push(l);
        lose[l].push(w);
    })
    
    const bfs = (graph, start) => {
        const queue = [start];
        const visited = [];
        
        visited[start] = 1;
        let count = 0;
        
        while(queue.length){
            const cur = queue.shift();
            for(const next of graph[cur]){
                if(visited[next]) continue;
                
                visited[next] = 1;
                queue.push(next);
                count++;
            }
        }
        return count;
    }
    
    for(let i=1; i<=n; i++){
        if(bfs(win, i) + bfs(lose, i) === n-1){
            answer++;
        }    
    }
    
    return answer;
}