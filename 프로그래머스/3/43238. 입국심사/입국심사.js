// n : 입국심사를 기다리는 사람 수
// times: 각 심사관이 한명을 심사하는데 걸리는 시간
function solution(n, times) {
    
    times.sort((a,b) => a-b); // 오름차순 정렬
    
    let left = 1;
    let right = times[times.length-1] * n; // 최대로 걸릴 수 있는 시간
    
    while(left <= right){
        const mid = Math.floor((left+right)/2);
        
        // 처리할 수 있는 최대 입국자 수 계산
        const sum = times.reduce((acc, cur) => acc + Math.floor(mid / cur), 0);
        
        if(sum < n){ // n보다 작다면 시간 증가
            left = mid+1;
        }else { // n보다 크거나 같다면 시간 감소
            right = mid-1;    
        }
    }
    
    return left;
}