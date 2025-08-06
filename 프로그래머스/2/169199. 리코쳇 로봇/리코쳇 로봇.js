function solution(board) {
    const N = board.length;
    const M = board[0].length;
    
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];
    
    let [startY, startX] = [0, 0]
    let [endY, endX] = [0, 0]
    
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (board[i][j] === 'R') [startY, startX] = [i, j];
            else if (board[i][j] === 'G') [endY, endX] = [i, j];
        }
    }
    
    const moveRobot = (y, x, dir) => {
        let ny = y;
        let nx = x;
        while (true) {
            let moveY = ny + dy[dir];
            let moveX = nx + dx[dir];
            if (moveY < 0 || moveX < 0 || moveY >= N || moveX >= M) break;
            if (board[moveY][moveX] === 'D') break;
            
            ny = moveY;
            nx = moveX;
        }
        return [ny, nx];
    }
    
    const bfs = () => {
        const queue = [];
        const visited = Array.from({ length: N }, () => Array(M).fill(0));
        
        visited[startY][startX] = 1;
        queue.push([startY, startX, 0]);
        
        while (queue.length) {
            const [y, x, count] = queue.shift();
            
            if (y === endY && x === endX) {
                return count;
            }
            
            for (let i = 0; i < 4; i++) {
                const [ny, nx] = moveRobot(y, x, i);
                
                if (visited[ny][nx]) continue;
                visited[ny][nx] = 1;
                queue.push([ny, nx, count + 1]);
            }
        }
        
        return -1;
    }
    
    
    return bfs();
}