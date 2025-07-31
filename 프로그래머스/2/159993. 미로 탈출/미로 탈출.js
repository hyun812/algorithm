function solution(maps) {
    let answer = -1;
    
    const N = maps.length;
    const M = maps[0].length;
    
    let [startY, startX] = [0, 0];
    let [endY, endX] = [0, 0];
    let [leverY, leverX] = [0, 0];
    
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (maps[i][j] === 'S') [startY, startX] = [i, j];
            else if (maps[i][j] === 'E') [endY, endX] = [i, j];
            else if (maps[i][j] === 'L') [leverY, leverX] = [i, j];
        }
    }
    
    const dy = [0, 0, -1, 1];
    const dx = [-1, 1, 0, 0];
    const bfs = (startY, startX, endY, endX) => {
        const queue = [[startY, startX, 0]];
        const visited = Array.from({ length: N }, () => Array(M).fill(0));
        
        visited[startY][startX] = 1;
        
        while (queue.length) {
            const [y, x, count] = queue.shift();
            
            if (y === endY && x === endX) return count;
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (maps[ny][nx] === 'X') continue;
                
                visited[ny][nx] = 1;
                queue.push([ny, nx, count + 1]);
            }
        }
        return -1;
    }
    
    const sl = bfs(startY, startX, leverY, leverX);
    const le = bfs(leverY, leverX, endY, endX);
    
    if (sl === -1 || le === -1) return -1;
    return sl + le;
}