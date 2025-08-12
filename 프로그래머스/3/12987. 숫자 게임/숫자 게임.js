function solution(A, B) {
    let answer = 0;
    
    A.sort((a, b) => a - b);
    B.sort((a, b) => a - b);
    
    let ap = 0;
    let bp = 0;
    
    while (ap < A.length && bp < A.length) {
        if (A[ap] < B[bp]) {
            answer++
            ap++;
            bp++;
        } else {
            bp++;
        }
    }
    
    
    return answer;
}
