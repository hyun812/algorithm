function solution(n, m, section) {
    let answer = 1;
    
    section.sort((a, b) => a-b);
    
    let paint = section[0];
    for(let i=1; i<section.length; i++){
        let target = section[i];
        
        if(paint + m - 1 >= target) continue;
        paint = target;
        answer++;
    }
    
    return answer;
}