function solution(progresses, speeds) {
    const answer = [];
    
    const N = progresses.length;
    const days = progresses.map((progress, i) => Math.ceil((100 - progress) / speeds[i]));

    let prev = days[0];
    let count = 1;
    for (let i = 1; i < N; i++) {
        const target = days[i];
        
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