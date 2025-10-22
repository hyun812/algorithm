function solution(targets) {
    targets.sort((a, b) => a[1] - b[1]);
    
    let answer = 1;
    let curEnd = targets[0][1];
    for (let i = 1; i < targets.length; i++) {
        const [s, e] = targets[i];
        
        if (curEnd > s) continue;
        curEnd = e;
        answer++;
    }
    return answer;
}