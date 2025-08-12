function solution(tickets) {
    const answer = [];
    const len = tickets.length;
    const visited = new Array(len).fill(0);
    
    // 티켓을 도착지 기준으로 사전순 정렬
    tickets.sort((a, b) => a[1].localeCompare(b[1]));
    
    const dfs = (cur, path) => {
        if (answer.length === 1) return;
        if (path.length === len + 1) {
            answer.push(path);
            return;
        }
        
        for (let i = 0; i < len; i++) {
            const [start, end] = tickets[i];
            
            if (visited[i]) continue;
            if (start !== cur) continue;
            
            visited[i] = 1;
            dfs(end, [...path, end]);
            visited[i] = 0;
        }
    }
    
    dfs("ICN", ["ICN"])
    
    return answer[0];
}