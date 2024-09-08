function solution(distance, rocks, n) {
    let answer = 0;
    if (rocks.length == n) return distance;
    
    rocks = [...rocks.sort((a, b) => a - b), distance];
    
    let left = 0;
    let right = rocks[rocks.length - 1];
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2); // 각 바위 사이 거리
        
        let count = 0; // 제거된 바위 수
        let now = 0;
        for(const rock of rocks) {
            if(rock - now < mid) {
                count++;
            }else {
                now = rock;
            }
        }
        
        if(count > n) {
            right = mid - 1;
        }else {
            left = mid + 1;  
            answer = Math.max(answer, mid);
        }
    }
    
    return answer;
}