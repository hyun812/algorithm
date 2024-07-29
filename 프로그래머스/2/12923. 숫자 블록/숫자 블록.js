function solution(begin, end) {
    const arr = [];
    
    for(let i=begin; i<=end; i++){
        arr.push(check(i));
    }
    
    return arr;
}

function check(n) {
    const checkArr = [];
    
    if(n === 1) return 0;
    
    for(let i=2; i<=Math.sqrt(n); i++){
        if(n%i ===0){
            checkArr.push(i);
            if(n/i <= 10000000){
                return n/i;
            }
        }
    }
    
    if(checkArr.length){
        return checkArr[checkArr.length-1];
    }
    
    return 1;
}