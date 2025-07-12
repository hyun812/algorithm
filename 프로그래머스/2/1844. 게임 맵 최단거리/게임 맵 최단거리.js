function solution(maps) {
    const m = maps.length;
    const n = maps[0].length;
    
    const dy = [0, 0, -1, 1];
    const dx = [-1, 1, 0, 0];
    
    const bfs = () => {
        const queue = [[0, 0, 1]];
        const visited = Array.from({ length: m }, () => Array(n).fill(0));
        
        visited[0][0] = 1;
        
        while (queue.length) {
            const [y, x, count] = queue.shift();
            
            if (y === m - 1 && x === n - 1) {
                return count;
            }
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (!maps[ny][nx]) continue;
                
                visited[ny][nx] = 1;
                queue.push([ny, nx, count + 1]);
            }
        }
        return -1;
    }
    
    return bfs();
}