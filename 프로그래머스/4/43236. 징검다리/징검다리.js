function solution(distance, rocks, n) {
    var answer = 0;
    if (rocks.length == n) return distance;

    rocks = [0, ...rocks.sort((a,b)=>a-b), distance];
    
    const binarySearch = () => {
        let left = 0;
        let right = rocks[rocks.length-1];
        
        while(left < right){
            let mid = Math.floor((left+right)/2);
            
            let count = 0, now = 0;
            
            for(let i=1; i<rocks.length; i++){
                if(rocks[i] - now < mid){ // 바위 삭제
                    count++;
                }else { // 현재 바위 위치 변경
                    now = rocks[i];
                }
            }
            
            if(count > n) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        answer = right-1;
    }
    
    binarySearch();
    
    
    
    return answer;
}