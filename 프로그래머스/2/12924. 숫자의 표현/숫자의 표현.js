function solution(n) {
    if (n === 1) return 1;
    
    let answer = n % 2 === 0 ? 1 : 2;
    
    for (let i = 1; i < Math.floor(n / 2); i++) {
        let sum = i;
        for (let j = i + 1; j < n; j++) {
            sum += j;
            
            if (sum === n) {
                answer++;
                break;
            }
            
            if (sum > n) break;
        }
    }
    
    return answer;
}