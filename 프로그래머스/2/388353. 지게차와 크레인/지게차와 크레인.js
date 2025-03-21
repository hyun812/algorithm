// 지게차 | 크레인
// 길이가 1이면 지게차 - 4면중 한면이라도 외부와 연결되어 있으면 꺼냄
// 길이가 2이면 크레인 - 모든 컨테이너를 꺼낼 수 있음
// 이때 남은 컨테이너의 개수

const dy = [1, -1, 0, 0];
const dx = [0, 0, -1, 1];

const bfs = (i, j, storage) => {
    const queue = [[i, j]];
    const visited = Array.from({ length: storage.length }, () => Array(storage[0].length).fill(0));
    
    visited[i][j] = 1;
    
    while (queue.length) {
        const [y, x] = queue.shift();
        
        for (let i = 0; i < 4; i++) {
            const ny = y + dy[i];
            const nx = x + dx[i];
            
            if (ny < 0 || nx < 0 || ny >= storage.length || nx >= storage[0].length) {
                return true;
            }
            
            if (!visited[ny][nx] && storage[ny][nx] === 0) {
                visited[ny][nx] = 1;
                queue.push([ny, nx]);
            }
        }
    }
    return false;
}
const forkLift = (storage, target) => {
    const deleteArr = [];
    
    for (let i = 0; i < storage.length; i++) {
        for (let j = 0; j < storage[0].length; j++) {
            if (storage[i][j] !== target) continue;
            if (!bfs(i, j, storage)) continue;
            
            deleteArr.push([i, j]);
        }
    }
    
    let count = 0;
    deleteArr.forEach(([y, x]) => {
        storage[y][x] = 0;
        count++;
    })
    
    return count;
}

const crane = (storage, target) => {
    let count = 0;
    for (let i = 0; i < storage.length; i++) {
        for (let j = 0; j < storage[0].length; j++) {
            if (storage[i][j] !== target) continue;
            storage[i][j] = 0;
            count++;
        }
    }    
    return count;
}

function solution(storage, requests) {
    let answer = storage.length * storage[0].length;
    
    storage = storage.map(row => row.split(''));

    for (const request of requests) {
        if (request.length === 1) {
            answer -= forkLift(storage, request);
        }else {
            answer -= crane(storage, request[0]);
        }
    }

    return answer;
}
