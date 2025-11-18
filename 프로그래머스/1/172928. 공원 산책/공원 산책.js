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
    
    const dy = [-1, 1, 0, 0]; // N, S, W, E
    const dx = [0, 0, -1, 1];
    
    const getDirection = (op) => {
        let index = -1
        switch (op) {
            case 'N' :
                index = 0;
                break;
            case 'S' :
                index = 1;
                break;
            case 'W' :
                index = 2;
                break;
            case 'E' :
                index = 3;
                break;
        }
        return index;
    }
    
    const isPosibble = (op, n) => {
        const dir = getDirection(op);        
        let ny = y;
        let nx = x;
        
        while (n--) {
            ny += dy[dir];
            nx += dx[dir];
            
            if (ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length) return false;
            if (park[ny][nx] === 'X') return false;
        }
        
        y = ny;
        x = nx;
        return true;
    }
    
    for (const route of routes) {
        const [op, n] = route.split(' ');
        isPosibble(op, n);
    }
    
    return [y, x];
}