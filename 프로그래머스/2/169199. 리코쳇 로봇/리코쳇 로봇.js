// 장애물이나 맨끝에 부딪힐 때까지 이동

function solution(board) {
    let answer = 0;
    
    let [startY, startX] = [0, 0];
    
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];
    
    const visited = Array.from({length: board.length}, ()=>Array(board[0].length).fill(0));
    
    for(let i=0; i<board.length; i++){
        for(let j=0; j<board[0].length; j++){
            if(board[i][j] !== "R") continue;
            
            startY = i;
            startX = j;
            break;
        }
    }
        
    const doit = () => {
        
        const queue = [ [startY, startX, 0] ];
        
        while(queue.length){
            const [y, x, cnt] = queue.shift();
            
            // 목표 지점이라면 리턴
            if(board[y][x] === 'G'){
                return cnt;
            }

            for(let i=0; i<4; i++){
                let ny = y;
                let nx = x;
                
                // 미끄러져서 이동
                while(true){
                    // 범위를 벗어낫거나
                    if(!outOfIdx(ny+dy[i], nx+dx[i])) break;
                    // 장애물이거나
                    if(board[ny+dy[i]][nx+dx[i]] === 'D') break;
                    
                    ny += dy[i];
                    nx += dx[i];
                }
                
                // 방문했던적이 있으면
                if(visited[ny][nx]) continue;
                
                visited[ny][nx] = 1;
                queue.push([ny, nx, cnt+1]);
            }
        }
    }
    
    const outOfIdx = (ny, nx) => {
        if(ny >= 0 && ny<board.length && nx>=0 && nx<board[0].length){
            return true;
        }
        return false;
    }
    
    answer = doit();
    
    
    return answer ? answer : -1;
}