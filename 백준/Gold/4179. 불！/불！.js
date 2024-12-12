const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [R, C] = input[0].split(' ').map(Number);
const map = Array.from({ length: R }, () => Array(C).fill(0));
const fireQueue = [];
const jihoonQueue = [];
for (let i = 0; i < R; i++) {
  const lines = input[i + 1].slice(0, C).split('');
  for (let j = 0; j < C; j++) {
    map[i][j] = lines[j];

    if (map[i][j] === 'J') {
      jihoonQueue.push([i, j]);
    } else if (map[i][j] === 'F') {
      fireQueue.push([i, j]);
    }
  }
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const jihoonVisited = Array.from({ length: R }, () => Array(C).fill(0));
const fireVisited = Array.from({ length: R }, () => Array(C).fill(0));

const bfs = () => {
  let time = 0;

  while (jihoonQueue.length) {
    const jihoonLength = jihoonQueue.length;
    const fireLength = fireQueue.length;

    for (let i = 0; i < fireLength; i++) {
      const [y, x] = fireQueue.shift();

      for (let i = 0; i < 4; i++) {
        const ny = y + dy[i];
        const nx = x + dx[i];

        if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
        if (map[ny][nx] === '#') continue;
        if (fireVisited[ny][nx]) continue;

        map[ny][nx] = 'F';
        fireVisited[ny][nx] = 1;
        fireQueue.push([ny, nx]);
      }
    }

    for (let i = 0; i < jihoonLength; i++) {
      const [y, x] = jihoonQueue.shift();

      for (let i = 0; i < 4; i++) {
        const ny = y + dy[i];
        const nx = x + dx[i];

        if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
          return time + 1;
        }
        if (jihoonVisited[ny][nx]) continue;
        if (map[ny][nx] !== '.') continue;

        jihoonQueue.push([ny, nx, time + 1]);
        jihoonVisited[ny][nx] = 1;
      }
    }
    time++;
  }

  return 'IMPOSSIBLE';
};

console.log(bfs());