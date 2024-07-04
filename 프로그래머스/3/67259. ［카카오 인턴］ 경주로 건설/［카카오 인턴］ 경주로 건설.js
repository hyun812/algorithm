function solution(board) {
    const len = board.length;
    const dy = [0, 1, 0, -1];
    const dx = [1, 0, -1, 0];
    
    const queue = [];
    const dp = Array(len).fill().map(() => Array(len).fill().map(() => Array(4).fill(Infinity)));
    
    queue.push([0, 0, 0, 0]);
    queue.push([0, 0, 0, 1]);
    
    const dfs = () => {
        
        while(queue.length){
            const [ y, x, cost, dir ] = queue.shift();
            
            for(let i=0; i<4; i++){
                const ny = dy[i] + y;
                const nx = dx[i] + x;
                
                if(ny<0 || nx<0 || ny>=len || nx>= len) continue;
                if(board[ny][nx]) continue;
                
                let roadCost = dir === i ? cost+100 : cost+600;
                
                // 비용이 더 크다면
                if(dp[ny][nx][i] > roadCost) { 
                    queue.push([ny, nx, roadCost, i]);
                    dp[ny][nx][i] = roadCost;    
                }
            }
        }
    }
    
    dfs();
    
    return Math.min(...dp[len-1][len-1]);
}