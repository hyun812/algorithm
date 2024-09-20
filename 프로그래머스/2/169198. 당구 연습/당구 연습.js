/** 
    m: 세로 길이
    n: 가로 길이
    startX, startY: 시작 지점 좌표
    balls: 목표로 해야하는 공이 놓인 위치 배열
**/
function solution(m, n, startX, startY, balls) {
    var answer = [];
    
    const getLength = (x, y) => {
        let points = [];
        
        if(startX !== x || startY < y) {
            points.push((startX-x)**2 + (startY+y)**2)
        }
        if(startX !== x || startY > y) {
            points.push((startX-x)**2 + (startY-(n + n - y))**2)
        }
        if(startY !== y || startX < x) {
            points.push((startX+x)**2 + (startY-y)**2)
        }
        if(startY !== y || startX > x) {
            points.push((startX-(m + m - x))**2 + (startY-y)**2)
        }
        
        return Math.min(...points);
    }
    
    balls.map((ball) => {
        const [x, y] = ball;
        const result = getLength(x, y);
        answer.push(result);
    })
    
    return answer;
}
