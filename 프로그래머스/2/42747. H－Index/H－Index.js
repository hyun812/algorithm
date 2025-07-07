function solution(citations) {
    let answer = 0;
    
    citations.sort((a, b) => a - b);
    
    const N = citations.length;
    const mid = Math.floor(N / 2);
    
    for (let i = 0; i < N; i++) {
        if (citations[i] >= N - i) {
            answer = N - i;
            break;
        }
    }
    
    
    return answer;
}