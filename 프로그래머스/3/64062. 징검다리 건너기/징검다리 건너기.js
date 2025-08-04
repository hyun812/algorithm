function solution(stones, k) {
    let left = 1;
    let right = 2000000000;
    let answer = 0;
    
   const isBridgeCrossable = (people) => {
        let count = 0;
        for (const stone of stones) {
            if (stone - people <= 0) {
                count += 1;
                if (count >= k) return false;
            } else {
                count = 0;
            }
        }
        return true;
    };
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        if (isBridgeCrossable(mid)) {
            left = mid + 1;
            answer = Math.max(answer, left);
        } else {
            right = mid - 1;
        }
    }
    
    return answer;
}