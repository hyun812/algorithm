function solution(record) {
    const answer = [];
    
    const map = new Map(); // 최종 닉네임
    for (const item of record) {
        const [type, id, nickname] = item.split(' ');
        if (type === 'Leave') continue;
        map.set(id, nickname);
    }
    
    for (const item of record) {
        const [type, id, nickname] = item.split(' ');
        
        if (type === 'Enter') {
            answer.push(`${map.get(id)}님이 들어왔습니다.`);
        } else if (type === 'Leave'){
            answer.push(`${map.get(id)}님이 나갔습니다.`)
        }
    }
    
    return answer;
}