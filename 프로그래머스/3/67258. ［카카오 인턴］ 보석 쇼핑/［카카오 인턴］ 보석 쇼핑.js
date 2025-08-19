function solution(gems) {
    const answer = [1, gems.length];
    const gemCount = new Set(gems).size;
    
    let left = 0;
    let right = 0;
    const map = new Map();
    map.set(gems[0], 1);
    
    while (right < gems.length) {
        if (map.size === gemCount) {
            if (answer[1] - answer[0] > right - left) {
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
            map.set(gems[left], map.get(gems[left]) - 1);
            if (map.get(gems[left]) === 0) map.delete(gems[left]);
            left++;
            
        } else {
            right++;
            map.set(gems[right], (map.get(gems[right]) || 0) + 1);
        }     
    }
    
    return answer;
}