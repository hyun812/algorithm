/*
    더한 값이 0보다 작으면 움직이지 않는다
    -1, +1, -10, +10, -100, +100
*/

function solution(storey) {
    let answer = 0;
    
    const arr = [-1, 1, -10, 10, -100, 100];
    const dp = [];
    
    // 만약 자리가 6,7,8,9 -> 더하기
    // 만약 자리가 1,2,3,4,5 -> 빼기
    
    let temp = 0;
    
    for(let i=storey.toString().length-1; i>=0; i--){
        
        let target = Number(storey.toString().split('')[i]) + temp;
        
        if(target > 5){
            answer += 10 - target;
            temp = 1;        
        }else if(target == 5){
            // 5인경우 앞자리까지 확인해주기
            const prev = i-1 >= 0 ? Number(storey.toString().split('')[i-1]) : 0;
            // console.log(prev);
            if(prev >= 5) {
                answer += 10 - target;
                temp = 1;        
            }else{
                answer += target;
                temp = 0;    
            }
        }else{
            answer += target;
            temp = 0;
        }
    }
    
    return temp === 1 ? answer+1 : answer;
}