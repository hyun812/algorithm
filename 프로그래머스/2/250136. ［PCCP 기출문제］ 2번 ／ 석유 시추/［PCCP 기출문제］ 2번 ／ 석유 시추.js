function solution(land) {
    const N = land.length;
    const M = land[0].length;
    
    const dy = [0, 0, -1, 1];
    const dx = [-1, 1, 0, 0];
    const visited = Array.from({ length: N }, () => Array(M).fill(0));
    
    const answer = Array(M).fill(0);
    const bfs = (startY, startX) => {
        let results = 1;
        const set = new Set();
        const queue = [[startY, startX]];
        visited[startY][startX] = 1;
        set.add(startX);
        
        while (queue.length) {
            const [y, x] = queue.shift();
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];                
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (land[ny][nx] === 0) continue;
                
                queue.push([ny, nx]);
                set.add(nx);
                visited[ny][nx] = 1;
                results++;
            }
        }
        
        for (const v of set) {
            answer[v] += results;
        }
    }
    
    
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (land[i][j] === 0) continue;
            if (visited[i][j]) continue;
            bfs(i, j);
        }
    }
    
    return Math.max(...answer);
}