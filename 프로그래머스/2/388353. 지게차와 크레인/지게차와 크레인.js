function solution(storage, requests) {
    storage = storage.map((line) => line.split(''));
    const N = storage.length;
    const M = storage[0].length;
    let answer = N * M;
    
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];

    const bfs = (startY, startX) => {
        const visited = Array.from({ length: N }, () => Array(M).fill(0));
        const queue = [[startY, startX]];
        visited[startY][startX] = 1;
        
        while (queue.length) {
            const [y, x] = queue.shift();
            
            for (let i = 0; i < 4; i++) {
                const ny = y + dy[i];
                const nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    return true;
                }
                
                if (!visited[ny][nx] && storage[ny][nx] === '*') {
                    visited[ny][nx] = 1;
                    queue.push([ny, nx]);
                }
            }
        }
        return false;
    }
    
    for (const request of requests) {
        if (request.length === 1) {
            const deleteArr = [];
            for (let y = 0; y < N; y++) {
                for (let x = 0; x < M; x++) {
                    if (storage[y][x] !== request) continue;
                    if (bfs(y, x)) {
                        deleteArr.push([y, x]);
                    }
                }
            }
            console.log(deleteArr)
            for (const [y, x] of deleteArr) {
                storage[y][x] = '*';
                answer--;
            }
        } else {
            for (let y = 0; y < N; y++) {
                for (let x = 0; x < M; x++) {
                    if (storage[y][x] !== request[0]) continue;
                    storage[y][x] = '*';
                    answer--;
                }
            }
        }
    }
    
    return answer;
}