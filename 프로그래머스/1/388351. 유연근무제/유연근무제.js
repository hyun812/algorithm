function solution(schedules, timelogs, startday) {
    const n = schedules.length;
    let answer = 0;
    
    for (let i = 0; i < n; i++) {
        let time = schedules[i] + 10;
        if (time % 100 >= 60) {
            time += 100;
            time -= 60;
        }
        
        let vaild = true;
        
        for (let j = 0; j < 7; j++) {
            let day = (startday + j) % 7;
                
            if (day === 6 || day === 0) continue;
            if (timelogs[i][j] > time) {
                vaild = false;
                break;        
            }
        }
        if (vaild) answer++;
    }
    return answer;
}