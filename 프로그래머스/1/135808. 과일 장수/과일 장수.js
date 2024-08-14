function solution(k, m, score) {
    var answer = 0;
    
    score.sort((a, b) => b-a);
    
    for(let i=0; i<score.length; i+=m){
        if(score.length-i < m) break;
        answer += score.slice(i, i+m)[m-1] * m;
    }

    
    return answer;
}