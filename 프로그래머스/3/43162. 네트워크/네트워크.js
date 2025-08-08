function solution(n, computers) {
    let answer = 0;
    const visited = Array(n).fill(0);
    
    const dfs = (index) => {
        
        const computer = computers[index];
        
        for (let i = 0; i < computer.length; i++) {
            if (visited[i]) continue;
            if (computer[i] === 0) continue;
            visited[i] = 1;
            dfs(i);
        }
        
    }
    
    for (let i = 0; i < n; i++) {
        if (visited[i]) continue;
        visited[i] = 1;
        dfs(i);
        answer++;
    }
    
    return answer;
}