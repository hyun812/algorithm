function solution(distance, rocks, n) {
    rocks.push(distance);
    rocks.sort((a, b) => a - b);
    
    const calcDist = (k) => {
        let count = 0;
        let prev = 0;
        for (let i = 0; i < rocks.length; i++) {
            if (rocks[i] - prev < k) {
                count++;
            } else {
                prev = rocks[i];
            }
        }
        
        if (count > n) return false;
        return true;
    }
    
    
    let answer = 0;    
    let left = 0;
    let right = distance;
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        if (calcDist(mid)) {
            left = mid + 1;
            answer = Math.max(answer, mid);
        } else {
            right = mid - 1;
        }
    }
    
    return answer;
}