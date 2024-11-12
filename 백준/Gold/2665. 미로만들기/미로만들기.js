const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const map = input.slice(1).map((lines) => lines.split('').map(Number));
const dist = Array.from({ length: n }, () => Array(n).fill(Infinity));

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const bfs = () => {
  const queue = [[0, 0]];
  dist[0][0] = 0;

  while (queue.length) {
    const [y, x] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

      if (map[ny][nx] === 0) {
        if (dist[ny][nx] > dist[y][x] + 1) {
          dist[ny][nx] = dist[y][x] + 1;
          queue.push([ny, nx]);
        }
      } else if (map[ny][nx] === 1) {
        if (dist[ny][nx] > dist[y][x]) {
          dist[ny][nx] = dist[y][x];
          queue.push([ny, nx]);
        }
      }
    }
  }
};

bfs();

console.log(dist[n - 1][n - 1]);