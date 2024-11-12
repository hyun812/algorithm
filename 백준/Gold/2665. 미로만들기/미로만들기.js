const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const map = input.slice(1).map((lines) => lines.split('').map(Number));

let answer = n * n;

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const bfs = () => {
  const queue = [[0, 0, 0]];
  const visited = Array.from({ length: n }, () => Array.from({ length: n }, () => Array(n * n).fill(0)));

  visited[0][0][0] = 1;

  while (queue.length) {
    const [y, x, count] = queue.shift();

    if (y === n - 1 && x === n - 1) {
      answer = Math.min(answer, count);
    }
    if (count >= answer) continue;

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

      if (map[ny][nx] === 0) {
        if (visited[ny][nx][count + 1]) continue;
        visited[ny][nx][count + 1] = 1;
        queue.push([ny, nx, count + 1]);
      } else if (map[ny][nx] === 1) {
        if (visited[ny][nx][count]) continue;
        visited[ny][nx][count] = 1;
        queue.push([ny, nx, count]);
      }
    }
  }
};

bfs();

console.log(answer);
