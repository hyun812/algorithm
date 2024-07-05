// n회 , t분 간격, m명의 승객 탑승 가능
function solution(n, t, m, timetable) {
    var answer = '';
    
    const table = timetable.map((time) => {
        const [hour, minute] = time.split(":");
        
        return Number(hour) * 60 + Number(minute);
    }).sort((a,b)=>a-b);
    
    let curBusTime = 540;
    for(let i=0; i<n; i++){
        let people = table.filter((time) => time<=curBusTime).length;
        
        if(i === n-1){ // 마지막 버스라면
            if(people >= m) { // 타야하는 크루수가 m명이상이라면
                curBusTime = table[m-1] - 1;
            }
        }else { // 기존 크루들을 태움
            if(people > m){ // 타야하는 크루수가 m보다 크다면
                table.splice(0, m);
            }else{
                table.splice(0, people);
            }
            curBusTime += t;
        }
    }
    
    const hour = Math.floor(curBusTime / 60);
    const minute = curBusTime % 60;
    
    answer = String(hour).padStart(2, "0") + ":" + String(minute).padStart(2, "0");
    
    return answer;
}