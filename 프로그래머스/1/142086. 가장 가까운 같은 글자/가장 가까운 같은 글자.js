function solution(s) {
    var answer = [];
    
    const map = new Map();
    for(let i=0; i<s.length; i++){
        const target = s[i];
        answer[i] = map.has(target) ? i-map.get(target) : -1;
        map.set(target, i);
    }

    
    return answer;
}