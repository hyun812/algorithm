function solution(food_times, k) {
    const total = food_times.reduce((acc,cur) => acc+cur , 0);
    if(total<=k) return -1
    
    // 남은 음식 시간을 기준으로 오름차순 정렬
    const foods = food_times.map((v, i) => [i+1, v]).sort((a, b) => a[1]-b[1]);    
    
    let len = foods.length;
    let baseTime = 0;
    let idx = 0;
    while(idx < len){
        const restTime = foods[idx][1] - baseTime; // 남은 시간
        const restFood = len - idx; // 남은 음식 개수
        
        const passTime = restTime * restFood;
        
        if(k < passTime) break; // 남은 시간 내에 모든 다음 음식을 먹을 수 없으면
        
        k -= passTime;
        baseTime += restTime;
        idx++;
    }
    const answer = foods.slice(idx).sort((a, b) => a[0]- b[0]);
    return answer[k % answer.length][0];
}