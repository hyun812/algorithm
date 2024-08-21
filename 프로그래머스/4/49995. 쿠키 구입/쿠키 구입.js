function solution(cookie) {
    var answer = 0;
    
    const len = cookie.length;
    const prefixSum = new Array(len+1).fill(0);
    for(let i=0; i<len; i++){
        prefixSum[i+1] = prefixSum[i] + cookie[i];
    }
    
    for(let m=0; m<len-1; m++){
        let left = m; // left 종료 지점
        let right = m+1; // right 시작 지점
        
        while(true){
            const lSum = prefixSum[m+1] - prefixSum[left];
            const rSum = prefixSum[right+1] - prefixSum[m+1];
            
            if(lSum === rSum){
                answer = Math.max(answer, lSum);
                right++;
                left--;
            }else if(lSum < rSum){
                left--;
            }else if(rSum <= lSum){
                right++;
            }else{
                break;
            }
            
        }
    }
    
    
    
    
    return answer;
}