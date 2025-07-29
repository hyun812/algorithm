function solution(n) {
    const answer = Array.from({ length: n }, () => Array(n).fill(0));
    const len = n * (n + 1) / 2
    
    const dy = [1, 0, -1];
    const dx = [0, 1, -1];
    
    let count = 1;
    let [y, x] = [0, 0];
    let dir = 0;
    while (count !== len + 1) {
        answer[y][x] = count;
        
        let ny = y + dy[dir];
        let nx = x + dx[dir];
        if (ny < 0 || nx < 0 || ny >= n || nx >= n || answer[ny][nx]) dir = (dir + 1) % 3;
        
        y = y + dy[dir];
        x = x + dx[dir];
        count++;
    }
    return answer.flat().filter(v => v);
}