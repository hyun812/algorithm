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
            const bottom = [x, -y];
            points.push(bottom)
        }
        if(startX !== x || startY > y) {
            const top = [x, n + n - y];
            points.push(top)
        }
        if(startY !== y || startX < x) {
            const left = [-x, y];
            points.push(left)
        }
        if(startY !== y || startX > x) {
            const right = [m + m -x, y];
            points.push(right)
        }
        
        return points.reduce((min, [x1, y1]) => {
            return Math.min(min, (startX-x1)**2 + (startY-y1)**2);
        }, m**2 + n**2)
    }
    
    balls.map((ball) => {
        const [x, y] = ball;
        const result = getLength(x, y);
        answer.push(result);
    })
    
    return answer;
}
