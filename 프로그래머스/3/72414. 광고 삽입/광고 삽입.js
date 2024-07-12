const calcTime = (time) => { // 초단위로 변환
    const [h, m ,s] = time.split(":");
    
    return (Number(h)*3600) + (Number(m)*60) + (Number(s));
}

function solution(play_time, adv_time, logs) {
    const playTime = calcTime(play_time);
    const advTime = calcTime(adv_time);
    
    const times = new Array(playTime).fill(0);
    
    logs.forEach((log) => {
        const [start, end] = log.split('-');        
        
        const ss = calcTime(start);
        const es = calcTime(end);
        times[ss]++;
        times[es]--;
    });

    for(let i=1; i<=playTime; i++){
        times[i] += times[i-1];
    }
    
    for(let i=1; i<=playTime; i++){
        times[i] += times[i-1];
    }
    
    let sum = times[advTime - 1];
    let idx = 0;
    
    for(let i=advTime-1; i<playTime; i++){
        const count = times[i] - times[i-advTime];
        
        if(sum < count){
            sum = count;
            idx = i-advTime+1;
        }
    }
    
    const h = Math.floor((idx / 3600)).toString().padStart(2, "0");
    const m = Math.floor((idx % 3600) / 60).toString().padStart(2, "0");
    const s = Math.floor((idx % 3600) % 60).toString().padStart(2, "0");
    
    return `${h}:${m}:${s}`;
}