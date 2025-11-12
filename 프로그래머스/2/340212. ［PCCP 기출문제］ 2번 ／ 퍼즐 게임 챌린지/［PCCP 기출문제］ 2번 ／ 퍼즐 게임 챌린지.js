/*
    diffs: 난이도
    time_cur: 현재 퍼즐 소요시간
    time_prev: 이전 퍼즐 소요시간
    level: 숙련도
    
    diff - level 만큼 퍼즐을 틀림
    퍼즐을 틀릴 때마다 time_cur + time_prev 만큼의 시간 소요 + time_cur
    제한 시간내에 퍼즐을 모두 해결하기위한 숙련도의 최솟값
    이분탐색을 숙련도로 계산해서 문제 해결
*/
function solution(diffs, times, limit) {
    const n = diffs.length;
    
    const getTotalTime = (level) => {
        let total_time = 0;
        for (let i = 0; i < n; i++) {
            if (diffs[i] <= level) {
                total_time += times[i];
            } else {
                const diff = diffs[i] - level;
                total_time += ((times[i - 1] || 0) + times[i]) * diff + times[i]
            }
        }
        return total_time;
    }
    
    let left = 1;
    let right = 100001;
    let answer = right; 
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        // 총 걸리는 시간
        const total_time = getTotalTime(mid);

        if (total_time > limit) {
            left = mid + 1;
        } else {
            answer = Math.min(mid, answer);
            right = mid - 1;
        }
    }
    
    return answer;
}