function solution(diffs, times, limit) {
    
    const check_time = (level) => {
        let prev_time = 0;
        let all_time = 0;
        for(let i=0; i<diffs.length; i++) {
            let diff = diffs[i];
            let cur_time = times[i];
        
            if(diff > level){
                all_time += ((prev_time + cur_time) * (diff - level));
            }
            
            all_time += cur_time;
            prev_time = cur_time;
        }
        
        return all_time <= limit
    }
    
    
    let left = 1;
    let right = 100000;
    let answer = right;
    
    while(left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        if(check_time(mid)) {
            right = mid - 1;
            answer = Math.min(answer, mid);
        }else {
            left = mid + 1;
        }
    }
    
    return answer;
}