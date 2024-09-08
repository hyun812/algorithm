function solution(n, times) {
    times.sort((a, b) => a - b);
    
    let left = 0;
    let right = times[times.length - 1] * n;
    let answer = times[times.length - 1] * n;
    while(left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        const count = times.reduce((acc, cur) => acc + Math.floor(mid / cur), 0);
        
        if(count < n) {
            left = mid + 1;
        }else {
            right = mid - 1;
            answer = Math.min(answer, mid);
        }
    }
    
    return answer;
}