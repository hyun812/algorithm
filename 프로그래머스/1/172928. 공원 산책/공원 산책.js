function solution(park, routes) {
    let [y, x] = [0, 0];
    
    outer: for (let i = 0; i < park.length; i++) {
        for (let j = 0; j < park[0].length; j++) {
            if (park[i][j] === 'S') {
                y = i;
                x = j;
                park[i][j] = 'O';
                break outer;
            }
        }
    }
    
    const dirs = { E: [0, 1], W: [0, -1], S: [1, 0], N: [-1, 0] };
    
    for (const route of routes) {
        const [op, n] = route.split(' ');
        let [ny, nx] = [y, x];
        let cnt = 0;
        while (cnt < Number(n)) {
            ny += dirs[op][0];
            nx += dirs[op][1];
            
            if (ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length) break;
            if (park[ny][nx] === 'X') break;
            cnt++;
        }
        
        if (Number(n) === cnt) [y, x] = [ny, nx];
    }
    
    return [y, x];
}