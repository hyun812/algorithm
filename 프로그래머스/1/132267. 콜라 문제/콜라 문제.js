function solution(a, b, n) {
    let answer = 0;
    
    while (n >= a) {
        const count = Math.floor(n / a) * b;
        answer += count;
        n = count + (n % a);
    }
    
    return answer;
}