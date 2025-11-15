function solution(schedules, timelogs, startday) {
    const n = schedules.length;
    
    const convertTime = (time) => {
        return Math.floor(time / 100) * 60 + time % 100;
    }
    
    schedules = schedules.map(time => convertTime(time));
    timelogs = timelogs.map(log => log.map(time => convertTime(time)));
    
    let answer = 0;
    
    for (let i = 0; i < n; i++) {
        let flag = true;
        for (let j = 0; j < 7; j++) {
            const today = (startday + j) % 7;
            if (today === 6 || today === 0) continue;
            if (schedules[i] + 10 < timelogs[i][j]) {
                flag = false;
                break;
            }

        }
        if (flag) answer++;
    }
    
    
    return answer;
}