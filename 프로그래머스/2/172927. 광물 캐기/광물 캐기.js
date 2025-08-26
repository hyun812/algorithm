// 광물 5개까지 캘 수 있음
// 광물이 없거나, 곡괭이가 없을 때 까지
function solution(picks, minerals) {
    let answer = 0;
    const n = minerals.length;
    const maxLen = (picks[0] + picks[1] + picks[2]) * 5;
    
    minerals.splice(maxLen);
    const priority = [];
    
    for (let i = 0; i < minerals.length; i += 5) {
        const temp = [0, 0, 0];
        
        for (let j = i; j < i + 5; j++) {
            if (minerals[j] === 'diamond') temp[0]++;
            else if (minerals[j] === 'iron') temp[1]++;
            else if (minerals[j] === 'stone') temp[2]++;            
        }
        priority.push(temp);
    }
    
    priority.sort((a, b) => {
        if (a[0] !== b[0]) {
            return b[0] - a[0] 
        } else if (a[1] !== b[1]) {
            return b[1] - a[1];
        } else if (a[2] !== b[2]) {
            return b[2] - a[2];
        }
    });
    
    for (const [d, i, s] of priority) {
        if (picks[0]) {
            answer += (d + i + s);
            picks[0]--;
        } else if (picks[1]) {
            answer += (d * 5) + i + s;
            picks[1]--;
        } else if (picks[2]) {
            answer += (d * 25) + (i * 5) + s;
            picks[2]--;
        }
    }
    return answer;
}