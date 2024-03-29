/*
    개수와 상관없이 동일한 가짓수의 토핑이 올라가면 공평함
    
*/
function solution(topping) {
    let answer = 0;
    
    let [lCnt, rCnt] = [1, 0];
    let lArr = Array(topping.length).fill(0);
    let rArr = Array(topping.length).fill(0);
    
    lArr[topping[0]] += 1;
    for(let i=1; i<topping.length; i++){
        if(!rArr[topping[i]]) rCnt += 1;
        rArr[topping[i]] += 1;
    }
    // i -> 현재 타겟
    for(let i=1; i<topping.length; i++){
        lArr[topping[i]] += 1;
        rArr[topping[i]] -= 1;

        
        if(lArr[topping[i]] === 1){
            lCnt++;    
        }
        
        if(rArr[topping[i]] === 0){
            rCnt--;
        }
        
        
        if(lCnt === rCnt) answer++;
    }
    
    
    
    return answer;
}