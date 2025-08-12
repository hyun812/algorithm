function solution(tickets) {
    const len = tickets.length;
    const visited = new Array(len).fill(false);
    
    // 티켓을 도착지 기준으로 사전순 정렬
    tickets.sort((a, b) => a[1].localeCompare(b[1]));
    
    const dfs = (current, path) => {
        if (path.length === len + 1) {
            return path;
        }
        
        for (let i = 0; i < len; i++) {
            if (visited[i]) continue;
            if (tickets[i][0] !== current) continue;
            
            visited[i] = true;
            const result = dfs(tickets[i][1], [...path, tickets[i][1]]);
            if (result) return result; // 첫 번째 완성된 경로 반환
            visited[i] = false;
        }
        
        return null;
    }
    
    return dfs("ICN", ["ICN"]);
}