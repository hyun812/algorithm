function solution(s) {
    let answer = 0;
    
    let sameCnt = 0;
    let diffCnt = 0;
    let target = "";
    
    for(const str of s){
        if(!target) target = str;
        
        target === str ? sameCnt++ : diffCnt++;
        
        if(sameCnt === diffCnt){
            answer++;
            sameCnt = 0;
            diffCnt = 0;
            target = "";
        }
    }
    
    if(target) answer++;
    
    return answer;
}