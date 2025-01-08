const timeToSeconds = (h, m, s) => {
    return h * 3600 + m * 60 + s;
}

const secondToTime = (s) => {
    const hour = Math.floor(s / 3600);
    const mimute = Math.floor((s % 3600) / 60);
    const second = Math.floor((s % 3600) % 60);
    
    return [hour, mimute, second];
}

// 초침: 1초에 6도
// 분침: 1분에 6도, 1초에 0.1도
// 시침: 1시간에 30도, 1분에 0.5도, 1초에 1/120도
const getDegree = (h, m, s) => {
    const hDegree = (h % 12) * 30 + m * 0.5 + s * (1 / 120);
    const mDegree = m * 6 + s * 0.1;
    const sDegree = s * 6;

    return [hDegree, mDegree, sDegree];
}

// 시침과 초침
const hourMatch = (cur, next) => {
    if(cur[0] > cur[2] && next[0] <= next[2]) return true;
    if(cur[2] === 354 && cur[0] > 354) return true;
    
    return false;
}

// 분침과 초침
const minuteMatch = (cur, next) => {
    if(cur[1] > cur[2] && next[1] <= next[2]) return true;
    if(cur[2] === 354 && cur[1] > 354) return true;
    
    return false;
}

function solution(h1, m1, s1, h2, m2, s2) {
    let answer = 0;
    
    const start = timeToSeconds(h1, m1, s1);
    const end = timeToSeconds(h2, m2, s2);

    for (let i = start; i < end; i++) {
        const [ch, cm, cs] = secondToTime(i);
        const [nh, nm, ns] = secondToTime(i + 1);
        
        const cur = getDegree(ch, cm, cs);
        const next = getDegree(nh, nm, ns);
        
        const hMatch = hourMatch(cur, next);
        const mMatch = minuteMatch(cur, next);
        
        if(hMatch && mMatch) {
            if (next[0] === next[1]) answer++;
            else answer += 2;
        }else if (hMatch || mMatch) {
            answer++;
        }
    }
    
    if(start == 0 || start == 43200) answer++;

    return answer;
}