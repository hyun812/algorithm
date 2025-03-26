function solution(grid) {
    const answer = [];
    
    const n = grid.length;
    const m = grid[0].length;
    
    const visited = Array.from({ length: n }, () => Array.from({ length: m }, () => Array(4).fill(0)));
    const dy = [-1, 0, 1, 0];
    const dx = [0, 1, 0, -1];
    
    const getNextDir = (order, d) => {
        let next = d;
        switch (order) {
            case "L" :
                next = (d + 3) % 4;
                break;
            case "R" :
                next = (d + 1) % 4;
                break;
        }
        return next;
    }
    
    // 들어오는 방향 기준으로
    const bfs = (i, j, k) => {
        const queue = [[i, j, k, 1]];
        visited[i][j][k] = 1;
        
        let count = 1;
        while (queue.length) {
            const [y, x, d] = queue.shift();
            
            const nextDir = getNextDir(grid[y][x], d);
            
            let ny = y + dy[nextDir];
            let nx = x + dx[nextDir];
            
            if (ny < 0) ny = n - 1;
            else if (ny >= n) ny = 0;
            if (nx < 0) nx = m - 1;
            else if (nx >= m) nx = 0;
            
            if (visited[ny][nx][nextDir]) return count;
            
            visited[ny][nx][nextDir] = 1
            queue.push([ny, nx, nextDir]);
            count++;
        }    
        
        return count;
    }
    
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            for (let k = 0; k < 4; k++) {
                if (visited[i][j][k]) continue;
                
                const count = bfs(i, j, k);
                
                answer.push(count);
            }
        }
    }
    
    return answer.sort((a, b) => a - b);
}