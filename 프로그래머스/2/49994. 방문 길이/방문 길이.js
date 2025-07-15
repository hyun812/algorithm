function solution(dirs) {
    let answer = 0;
    
    const dy = [0, 0, -1, 1];
    const dx = [1, -1, 0, 0];
    const dir = ["U", "D", "L", "R"];
    
    let [y, x] = [0, 0];
    const visited = new Set();
    for (const d of dirs) {
        const i = dir.indexOf(d);
        const ny = y + dy[i];
        const nx = x + dx[i];
        
        if (ny < -5 || ny > 5 || nx < -5 || nx > 5) continue;
        const key1 = `${y}${x}${ny}${nx}`;
        const key2 = `${ny}${nx}${y}${x}`;
        y = ny;
        x = nx;
        if (visited.has(key1)) continue;
        visited.add(key1);
        if (visited.has(key2)) continue;
        visited.add(key2);
        answer++;
    }
    
    return answer;
}