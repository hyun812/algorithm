function solution(tickets) {
    var answer = [];
    
    const result = [];
    const visited = [];
    
    const len = tickets.length;
    const dfs = (now, count, path) => { // now: 현재 도시 , count: 사용한 티켓 수, path: 경로
        
        if(count === len){
            answer.push(path);
            return;
        }
        
        for(let i=0; i<len; i++){
            const from = tickets[i][0];
            const to = tickets[i][1];
            
            if(now !== from) continue;
            if(visited[i]) continue;
            
            const nextPath = [...path, to];
            
            visited[i] = 1;
            dfs(to, count+1, nextPath);
            visited[i] = 0;
        }
    }
    
    dfs("ICN", 0, ["ICN"]);
    
    // 가능한 모든 경로 탐색 후 알파벳 순서로 정렬
    return answer.sort()[0];
}