// 멈춰둔 과제가 여러개라면 가장 최근 멈춘 과제 부터 --> stack
// 
// 과제를 끝낸 순서대로 이름

function solution(plans) {
    const result = [];
    
    const sortPlans = plans
    .map((plan)=>{
        const [name, time, spend] = plan;
        const [hour, minute] = time.split(':');
        const convertedTime = Number(hour) * 60 + Number(minute);
        
        return [name, convertedTime, Number(spend)];
    })
    .sort((a,b) => b[1] - a[1]);  // 빠른 시간순으로 정렬
    
    const waitPlan = [];
    
    while(sortPlans.length){
        const [name, startTime, runningTime] = sortPlans.pop();
        
        waitPlan.forEach((wait, index) => {
            if(startTime < wait[1]) waitPlan[index][1] += runningTime;
        });
        
        waitPlan.push([name, startTime + runningTime]);
    }
    
    return waitPlan.sort((a, b) => a[1] - b[1]).map((plan) => plan[0]);
}