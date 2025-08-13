function solution(s) {
    var answer = 0;
    let p = 0;
    
    while (p < s.length) {
        const x = s[p];
        let xCount = 1;
        let count = 0;
        p++;
        
        while (p < s.length) {
            if (xCount === count) {
                answer++;
                break;
            }
            if (x === s[p]) xCount++;
            else count++;
            p++;
        }
    }
    
    return answer + 1;
}