function solution(n, s) {
    const mid = Math.floor(s/n);
    
    
    if(mid < 1) return [-1];
    
    const answer = new Array(n).fill(mid);
    const rest = Math.floor(s % n);
    
    for(let i=0; i<rest; i++){
        answer[answer.length-1-i]++;
    }
    
    return answer;
}