// k = 현재 피로도
// dungeons = [최소 필요 피로도, 소모 피로도]
function solution(k, dungeons) {
    let answer = 0;
    
    const visited = Array(dungeons.length).fill(0);

    const dfs = (cur, result, count) => {
        if (answer > result + dungeons.length - count) return;
        if (count === dungeons.length) {
            answer = Math.max(answer, result);
            return;
        }
        
        for (let i = 0; i < dungeons.length; i++) {
            const [minimum, consumption] = dungeons[i];
                
            if (visited[i]) continue;
            if (cur < minimum) continue;
            
            visited[i] = 1;
            dfs(cur - consumption, result + 1, count + 1);
            visited[i] = 0;
            dfs(cur, result, count + 1);
        }
    }
    
    dfs(k, 0, 0);
    
    return answer;
}