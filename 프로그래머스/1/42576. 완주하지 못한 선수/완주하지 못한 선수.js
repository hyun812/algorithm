function solution(participant, completion) {
    const map = new Map();
    for (const name of completion) {
        map.set(name, (map.get(name) || 0) + 1);
    }
    
    for (const name of participant) {
        if (!map.has(name) || map.get(name) === 0) return name;
        
        map.set(name, map.get(name) - 1);
    }
}