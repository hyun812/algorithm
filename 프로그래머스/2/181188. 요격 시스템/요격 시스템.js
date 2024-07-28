function solution(targets) {
    let answer = 0;
    
    targets.sort((a, b) => a[1] - b[1]);
    
    let prevEnd = -1;
    for(let i=0; i<targets.length; i++){
        const [start, end] = targets[i];
        
        if(prevEnd <= start) {
            prevEnd = end;
            answer++;
        }
    }
    
    return answer;
}