/*
    k : 부분수열의 합
    -> 여러개인 경우 길이가 짧은 수열
    -> 그것도 여러개라면 인덱스가 작은 수열
    
    result - 시작인덱스 마지막 인덱스
*/
function solution(sequence, k) {
    
    const answer = [];
    
    let left = 0;
    let right = 0;
    let sum = sequence[0];
    let len = Infinity;
    // 작으면 right ++ , 크면 left++
    
    while(right < sequence.length){
        
        if(sum == k){
            if(len > (right-left+1)){
                len = right-left+1;
                answer[0] = left;
                answer[1] = right;
            }
            right++;
            sum += sequence[right];
        }else if(sum < k){
            right++;
            sum += sequence[right];
        }else if(sum > k){
            sum -= sequence[left];
            left++;
        }
    }
    
    
    
    return answer;
}