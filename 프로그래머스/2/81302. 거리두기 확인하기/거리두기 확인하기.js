function solution(places) {
    const answer = [];
    
    const dy = [0, 0, -1, 1];
    const dx = [-1, 1, 0, 0];
    const isPosibblePlace = (place) => {
        const queue = [];
        for (let i = 0; i < 5; i++) {
            for (let j = 0; j < 5; j++) {
                if (place[i][j] !== 'P') continue;
                queue.push([i, j]);
            }
        }
        
        while (queue.length) {
            const [y, x] = queue.shift();
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
                if (place[ny][nx] === 'P') return 0;
                if (place[ny][nx] === 'X') continue;
                
                for (let j = 0; j < 4; j++) {
                    const nny = ny + dy[j];
                    const nnx = nx + dx[j];

                    if (nny < 0 || nnx < 0 || nny >= 5 || nnx >= 5) continue;
                    if (nny === y && nnx === x) continue;
                    if (place[nny][nnx] === 'P') return 0;
                }
            }
        }
        
        return 1;
    }
    
    for (const place of places) {
        answer.push(isPosibblePlace(place))
    }
    
    return answer;
}