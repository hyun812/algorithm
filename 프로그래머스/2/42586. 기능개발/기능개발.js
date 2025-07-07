function solution(progresses, speeds) {
    const N = progresses.length;
    
    const answer = [];
    const stack = [];
    
    for (let i = 0; i < N; i++) {
        const progress = progresses[i];
        const speed = speeds[i];
        
        const rest = 100 - progress;
        const deploy = rest % speed === 0 ? rest / speed : Math.floor(rest / speed) + 1;
        
        stack.push(deploy);
    }
    
    let prev = stack[0];
    let count = 1;
    for (let i = 1; i < N; i++) {
        const target = stack[i];
        
        if (prev >= target) {
            count++;
        }else {
            answer.push(count);
            prev = target;
            count = 1;
        }
    }
    answer.push(count);
    
    return answer;
}