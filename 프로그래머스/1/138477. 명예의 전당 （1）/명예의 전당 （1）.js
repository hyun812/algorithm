function solution(k, score) {
    let answer = [];
    
    const hall = [];
    
    score.forEach((s) => {
        hall.push(s);
        hall.sort((a, b) => b-a);
        
        answer.push(hall.length >= k ? hall[k-1] : hall[hall.length-1]);
    })
    
    
    return answer;
}