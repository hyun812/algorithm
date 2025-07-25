function solution(maps) {
    const answer = [];
    const m = maps.length;
    const n = maps[0].length;
    
    const dy = [0, 0, -1, 1];
    const dx = [-1, 1, 0, 0];
    const visited = Array.from({ length: m }, () => Array(n).fill(0));
    const bfs = (startY, startX) => {
        const queue = [];
        
        let days = Number(maps[startY][startX]);
        queue.push([startY, startX]);
        visited[startY][startX] = 1;
        
        while (queue.length) {
            const [y, x] = queue.shift();
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (maps[ny][nx] === 'X') continue;
                // console.log(ny, nx, maps[ny][nx], days);
                visited[ny][nx] = 1;
                queue.push([ny, nx]);
                days += Number(maps[ny][nx]);
            }
        }
        return days;
    }
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (visited[i][j]) continue;
            if (maps[i][j] === 'X') continue;
            answer.push(bfs(i, j));
        }
    }
    
    if (!answer.length) answer.push(-1);
        
    return answer.sort((a, b) => a - b);
}