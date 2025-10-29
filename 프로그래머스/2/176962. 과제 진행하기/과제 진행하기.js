function solution(plans) {
    const timeToMinutes = (time) => {
        const [h, m] = time.split(':').map(Number);
        return h * 60 + m;
    }

    plans = plans
        .map(([name, start, playtime]) => [name, timeToMinutes(start), Number(playtime)])
        .sort((a, b) => a[1] - b[1]);
    
    const answer = [];
    const stack = [];
    while (plans.length) {
        const [name, start, playTime] = plans.shift();
        
        if (plans.length) {
            const [_, nextStart] = plans[0]; // 다음 과제 확인
            
            if (start + playTime > nextStart) { // 과제를 다 끝내지 못한 경우
                stack.push([name, start + playTime - nextStart]);
            } else { // 과제를 시간 내 끝낸 경우
                answer.push(name);
                
                if (stack.length) {
                    const [pName, pTime] = stack.pop();
                    plans.unshift([pName, start + playTime, pTime]);
                }
            }
        } else {
            answer.push(name);
        }
    }
     
    answer.push(...stack.reverse().map(v => v[0]));
    return answer;
}