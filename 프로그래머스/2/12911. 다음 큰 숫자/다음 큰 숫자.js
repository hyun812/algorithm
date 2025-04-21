function solution(n) {
    const len = n.toString(2).split('1').length - 1;
    
    let answer = n + 1;
    while (true) {
        const nextLen = answer.toString(2).split('1').length - 1;
        if (len === nextLen) break;
        
        answer++;
    }
    
    
    return answer;
}