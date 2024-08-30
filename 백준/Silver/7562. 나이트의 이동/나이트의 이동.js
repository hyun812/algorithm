const bfs = (startY, startX, endY, endX, l) => {
  const queue = [[startY, startX, 0]];
  const visited = Array.from({ length: l }, () => Array(l).fill(0));

  visited[startY][startX] = 1;

  while (queue.length) {
    const [y, x, cnt] = queue.shift();

    if (y === endY && x === endX) return cnt;

    for (let i = 0; i < 8; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= l || nx >= l) continue;
      if (visited[ny][nx]) continue;

      visited[ny][nx] = 1;
      queue.push([ny, nx, cnt + 1]);
    }
  }
};

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const tc = +input[0];
const dy = [-1, -2, 1, 2, 1, 2, -1, -2];
const dx = [-2, -1, -2, -1, 2, 1, 2, 1];

for (let i = 0; i < tc; i++) {
  const l = +input[i * 3 + 1];
  const [startY, startX] = input[i * 3 + 2].split(' ').map(Number);
  const [endY, endX] = input[i * 3 + 3].split(' ').map(Number);

  const answer = bfs(startY, startX, endY, endX, l);
  console.log(answer);
}