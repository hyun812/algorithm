// 소수는 다 1임
// 나머지 나누어떨어지는 가장 큰수를 찾아야함
function solution(begin, end) {
    const check = (num) => {
        if (num === 1) return 0;
        
        let maxDivisor = 1;
        
        for (let i = 2; i <= Math.sqrt(num); i++) {
            if (num % i === 0) {
                if (num / i <= 1e7) return num / i;
                maxDivisor = i;
            }   
        }
        return maxDivisor;
    }
    
    const answer = [];
    for (let i = begin; i <= end; i++) {
        answer.push(check(i));
    }
    return answer;
}