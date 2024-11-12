const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M, A, B, K] = input[0].split(' ').map(Number);
const map = Array.from({ length: N }, () => Array(M).fill(0));

for (let i = 1; i <= K; i++) {
  const [y, x] = input[i].split(' ').map((v) => Number(v) - 1);

  map[y][x] = 1; // 장애물
}

const [startY, startX] = input[K + 1].split(' ').map((v) => Number(v) - 1);
const [endY, endX] = input[K + 2].split(' ').map((v) => Number(v) - 1);

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const isPossible = (y, x) => {
  if (y < 0 || y + A - 1 >= N) return false;
  if (x < 0 || x + B - 1 >= M) return false;

  for (let i = y; i < y + A; i++) {
    for (let j = x; j < x + B; j++) {
      if (map[i][j] === 1) return false;
    }
  }

  return true;
};

let answer = -1;
const bfs = () => {
  const queue = [[startY, startX, 0]];
  const visited = Array.from({ length: N }, () => Array(M).fill(0));
  visited[startY][startX] = 1;

  while (queue.length) {
    const [y, x, count] = queue.shift();

    if (y === endY && x === endX) {
      answer = count;
      return;
    }

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (!isPossible(ny, nx)) continue;
      if (visited[ny][nx]) continue;

      queue.push([ny, nx, count + 1]);
      visited[ny][nx] = 1;
    }
  }
};

bfs();

console.log(answer);