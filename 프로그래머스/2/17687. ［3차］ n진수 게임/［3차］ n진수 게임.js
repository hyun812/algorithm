function solution(n, t, m, p) {
    let answer = '';
    const max_len = t * m;
    
    const arr = Array(max_len).fill(0).map((_, i) => i.toString(n).toUpperCase()).join('');
    
    for (let i = 0; i < t; i++) {
        const index = (i * m) + p - 1;
        answer += arr[index];
    }
    
    return answer;
}