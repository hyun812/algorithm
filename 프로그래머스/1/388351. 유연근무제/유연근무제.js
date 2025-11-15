function solution(schedules, timelogs, startday) {
    const n = schedules.length;
    
    const convertTime = (time) => {
        const s = String(time).padStart(4, '0');
        const h = Number(s.slice(0, 2));
        const m = Number(s.slice(2, 4));
        return h * 60 + m;
    }
    
    schedules = schedules.map(time => convertTime(time));
    timelogs = timelogs.map(log => log.map(time => convertTime(time)));
    
    let answer = 0;
    let day = startday - 1;
    for (let i = 0; i < n; i++) {
        const timelog = timelogs[i];
        let flag = true;
        for (const time of timelog) {
            day++;
            if (day == 8) day = 1;
            if (day === 6 || day === 7) continue;
            if (schedules[i] + 10 < time) {
                flag = false;
                break;
            }
            
        }
        
        day = startday - 1;
        if (flag) answer++;
    }
    
    
    return answer;
}