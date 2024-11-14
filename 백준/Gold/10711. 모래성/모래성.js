const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [H, W] = input[0].split(' ').map(Number);
const map = Array.from({ length: H }, () => Array(W).fill(0));
const queue = [];
for (let i = 0; i < H; i++) {
  const lines = input[i + 1].split('');
  for (let j = 0; j < W; j++) {
    if (lines[j] === '.') {
      map[i][j] = lines[j];
      queue.push([i, j]);
    } else {
      map[i][j] = +lines[j];
    }
  }
}

const dy = [-1, 1, 0, 0, 1, 1, -1, -1];
const dx = [0, 0, -1, 1, 1, -1, 1, -1];
let count = 0;
const bfs = () => {
  while (queue.length) {
    const size = queue.length;

    for (let i = 0; i < size; i++) {
      const [y, x] = queue.shift();

      for (let i = 0; i < 8; i++) {
        const ny = y + dy[i];
        const nx = x + dx[i];

        if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
        if (map[ny][nx] === '.') continue;

        map[ny][nx]--;
        if (map[ny][nx] === 0) {
          map[ny][nx] = '.';
          queue.push([ny, nx]);
        }
      }
    }
    count++;
  }
};

bfs();

console.log(count - 1);