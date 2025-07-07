// k = 현재 피로도
// dungeons = [최소 필요 피로도, 소모 피로도]
function solution(k, dungeons) {
    let answer = 0;
    
    const visited = Array(dungeons.length).fill(0);

    const dfs = (cur, count) => {
        answer = Math.max(answer, count);
        
        for (let i = 0; i < dungeons.length; i++) {
            const [minimum, consumption] = dungeons[i];
                
            if (visited[i]) continue;
            if (cur < minimum) continue;
            
            visited[i] = 1;
            dfs(cur - consumption, count + 1);
            visited[i] = 0;
        }
    }
    
    dfs(k, 0);
    
    return answer;
}