function solution(n, times) {
    
    times.sort((a, b) => a - b);
    
    let left = 0;
    let right = times[times.length - 1] * n;
    let answer = right;
    
    // 시간을 기준으로 이분탐색 진행
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        const count = times.reduce((acc, cur) => Math.floor(mid / cur) + acc, 0);
        
        if (n <= count) {
            right = mid - 1;
            answer = Math.min(answer, mid);
        } else {
            left = mid + 1;
        }
    }
    
    return answer;
}