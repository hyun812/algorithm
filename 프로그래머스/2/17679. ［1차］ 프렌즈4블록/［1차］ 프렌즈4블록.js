function solution(m, n, board) {
    let answer = 0;
    
    board = board.map(v => v.split(''));
    
    const getDestroyBlock = () => {
        const arr = [];
        for (let i = 0; i < m - 1; i++) {
            for (let j = 0; j < n - 1; j++) {
                if (!board[i][j]) continue;
                if (board[i][j] === board[i + 1][j] && board[i][j] === board[i][j + 1] && board[i][j] === board[i + 1][j + 1]) {
                    arr.push([i, j], [i + 1, j], [i, j + 1], [i + 1, j + 1]);
                }
            }
        } 
        return arr;
    }
    
    const downBlock = () => {
        
        for (let i = 0; i < n; i++) {
            const stack = [];
            for (let j = m - 1; j >= 0; j--) {
                if (!board[j][i]) continue;
                stack.push(board[j][i]);
                board[j][i] = null;
            }
            
            for (let j = 0; j < stack.length; j++) {
                board[m - j - 1][i] = stack[j];
            }
        }
    }
    
    while (true) {
        const results = getDestroyBlock();

        if (!results.length) break;
        
        for (const [y, x] of results) {
            board[y][x] = null;
        }
        
        downBlock();
    }
    
    return board.flat().filter(v => v === null).length;
}