/*  n = 5일때
    1
    2 12 (3*n - 3)
    3 13 11
    4 14 15 10
    5  6  7  8  9   
*/

function solution(n) {
    
    const arr = Array.from({ length: n }, (_, index) => new Array(index+1).fill(0));
    
    let curX = -1;
    let curY = 0;
    let count = 0;
    
    while(n > 0){
        // 위->아래
        for(let i=0; i<n; i++){
            count++;
            curX++;
            arr[curX][curY] = count;
        }

        // 좌->우
        for(let i=0; i<n-1; i++){
            count++;
            curY++;
            arr[curX][curY] = count;
        }

        // 좌측 대각선 위로
        for(let i=0; i<n-2; i++){
            count++;
            curY--;
            curX--;
            arr[curX][curY] = count;
        }
        n -= 3;
    }
    
    let answer = [];
    for (let i = 0; i < arr.length; i++) {
        answer = [...answer, ...arr[i]];
    }
    
    return answer;
}