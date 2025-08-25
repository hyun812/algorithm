function solution(board) {
    let answer = Infinity;
    const n = board.length;
    
    const dy = [0, 1, 0, -1];
    const dx = [1, 0, -1, 0];
    const bfs = () => {
        const queue = [[0, 0, 0, 0], [0, 0, 1, 0]];
        const dp = Array.from({ length: n }, () => Array.from({ length: n }, () => Array(4).fill(Infinity)));
        
        while (queue.length) {
            const [y, x, dir, cost] = queue.shift();
            
            if (y === n - 1 && x === n - 1) {
                answer = Math.max(answer, cost);
                continue;
            }
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (board[ny][nx] === 1) continue;
                
                const newCost = cost + (dir === i ? 100 : 600);
                if (newCost < dp[ny][nx][i]) {
                    dp[ny][nx][i] = newCost;
                    queue.push([ny, nx, i, newCost]);
                }
            }
        }
        return Math.min(...dp[n - 1][n - 1]);
    }
    
    
    return bfs();
}