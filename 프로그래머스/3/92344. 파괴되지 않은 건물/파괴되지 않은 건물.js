function solution(board, skill) {
    var answer = 0;
    
    const sum = Array.from({length: board.length+1}, ()=>Array(board[0].length+1).fill(0));
    
    skill.forEach((value)=>{
        const [type, r1, c1, r2, c2, degree] = value;
        
        const reD = type === 1 ? -degree : degree;
        sum[r1][c1] += reD;
        sum[r2+1][c2+1] += reD;
        sum[r1][c2+1] += -reD;
        sum[r2+1][c1] += -reD;
    })
    
    // 위쪽에서 아래쪽 누적합 진행
    for(let i=0; i<sum.length; i++){
        for(let j=1; j<sum[0].length; j++){
            sum[i][j] += sum[i][j-1];
        }
    }
    
    // 왼쪽에서 오른쪽 누적합 진행
    for(let i=1; i<sum.length; i++){
        for(let j=0; j<sum[0].length; j++){
            sum[i][j] += sum[i-1][j];
        }
    }
    
    // board와 누적합 합산
    for(let i=0; i<board.length; i++){
        for(let j=0; j<board[0].length; j++){
            board[i][j] += sum[i][j];
        }
    }
    
    return board.map(v=>v.filter(v2=>v2>0).length).reduce((acc,cur)=>acc+cur);
}