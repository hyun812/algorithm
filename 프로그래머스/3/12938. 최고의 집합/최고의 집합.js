function solution(n, s) {
    const answer = [];
    
    const mid = Math.floor(s / n);
    
    if (!mid) return [-1];
    
    if (s % n === 0) {
        for (let i = 0; i < n; i++) {
            answer[i] = mid;
        }
    } else {
        let count = s % n;
        let rest = n - count;
        
        for (let i = 0; i < rest; i++) {
            answer.push(mid);    
        }
        
        for (let i = 0; i < count; i++) {
            answer.push(mid + 1);
        }
    }
    
    return answer;
}