function solution(board) {
    let answer = -1;
    
    let oCnt = 0;
    let xCnt = 0;
    
    for(let i=0; i<3; i++){
        for(let j=0; j<3; j++){
            const target = board[i][j];
            
            if(target === '.') continue;
            
            if(target === 'O') {
                oCnt++;  
            } else if(target === 'X') {
                xCnt++;
            }
        }
    }
    
    // x 개수가 더많다면 불가능
    if(oCnt < xCnt) return 0;
    // 두 수의 차이가 1보다 많이난다면 불가능
    if(Math.abs(oCnt-xCnt) > 1) return 0;
    
    const gameCheck = (winner) => {
        // 가로 체크
        for(let i=0; i<3; i++){
            if(board[i][0] === winner && board[i][1] === winner && board[i][2] === winner){
                return true;   
            }
        }
        // 세로 체크
        for(let i=0; i<3; i++){
            if(board[0][i] === winner && board[1][i] === winner && board[2][i] === winner){
                return true;   
            }
        }
        // 대각선 체크
        if(board[0][0] === winner && board[1][1] === winner && board[2][2] === winner){
            return true;   
        }
        if(board[0][2] === winner && board[1][1] === winner && board[2][0] === winner){
            return true;   
        }
        
        return false;
    }
    
    // 카운트가 같다면 o가 이겼다면 x를 한번 더 사용한 것
    if(oCnt === xCnt){
        if(gameCheck("O")){
            return 0;
        }
    }
    // 카운트가 1차이 나는데 x가 이길 수 없음
    else{
        if(gameCheck("X")) {
            return 0;
        }else {
            return 1;
        }
    }
    
    return 1;
}