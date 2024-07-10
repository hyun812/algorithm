function solution(info, edges) {
    let answer = 0;
    
    const arr = Array.from({length: info.length}, () => []);
    
    edges.forEach(([v1, v2]) => {
        arr[v1].push(v2);
    })
        
    const dfs = (cur, next, sheep, wolf) =>{
        info[cur] === 0 ? sheep++ : wolf++;
        
        if(wolf >= sheep) return;
        answer = Math.max(answer, sheep);
        
         // 갈 수 있는 노드 배열에서 현재 노드 삭제
        let possible = [...next, ...arr[cur]].filter(n => n !== cur);
        
        for (let node of possible) {
            dfs(node, possible, sheep, wolf);
        }
    }
    
    dfs(0, [0], 0, 0);
    
    return answer;
}