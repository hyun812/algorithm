function solution(n) {
    let answer = 0;
    const board = Array(n).fill(0);
    
    const check = (y, x, board) => {
        for (let i = 0 ; i < y; i++) {
            if (board[i] === x) return false;
            if (Math.abs(y - i) === Math.abs(x - board[i])) return false;
        }
        
        return true
    }
    
    const dfs = (y, board) => {
        const tmpBoard = [...board];
        if (y === n) {
            answer++;
            return;
        }
        
        for (let x = 0; x < n; x++) {
            if (!check(y, x, tmpBoard)) continue;
            tmpBoard[y] = x;
            dfs(y + 1, tmpBoard);
        }   
    }
    
    dfs(0, board);
    
    return answer;
}