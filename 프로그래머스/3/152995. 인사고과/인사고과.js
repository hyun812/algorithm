function solution(scores) { // 근무태도 , 동료평가
    var answer = 1;
    
    const [t1, t2] = scores[0];
    
    scores.sort((a, b) => {
        if(a[0] !== b[0]) return b[0] - a[0];
        return a[1] - b[1];
    })
    
    let before = 0;
    for(const [s1, s2] of scores){
        if(t1 < s1 && t2 < s2) return -1; // 인센티브를 받지 못함
        
        if(before <= s2){
            if(t1 + t2 < s1 + s2) answer++;
            before = s2;
        }
    }
    
    return answer;
}