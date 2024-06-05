function solution(weights) {
    let answer = 0;
    
    const ratio = [1, 3/2, 2, 4/3];
    const map = new Map();
    
    weights.sort((a, b) => b-a).forEach((w)=>{
        
        ratio.forEach((r) =>{
            if(map.has(w*r)) {
                answer += map.get(w * r);
            }
        })
        
        map.set(w, (map.get(w) || 0) +1);
    })
    
    
    return answer;
}