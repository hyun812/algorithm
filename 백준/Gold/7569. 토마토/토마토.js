const fs = require('fs');
// const [N, ...input] = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const [temp, ...input] = fs
  .readFileSync('./dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map((item) => item.split(' ').map(Number));

const [m, n, h] = temp;

const arr = Array.from({ length: h }, () => Array.from({ length: n }, () => Array.from(Array(m).fill(0))));
for (let i = 0; i < h; i++) {
  for (let j = 0; j < n; j++) {
    arr[i][j] = input.shift();
  }
}

const dy = [-1, 1, 0, 0, 0, 0];
const dx = [0, 0, -1, 1, 0, 0];
const dz = [0, 0, 0, 0, -1, 1];

// const visited = Array.from({ length: h }, () => Array.from({ length: n }, () => Array.from(Array(m).fill(0))));

// 1: 익은 토마토, 0: 익지 않은 토마토, -1: 비어있음
let tomato = [];
let count = 0;
for (let i = 0; i < h; i++) {
  for (let j = 0; j < n; j++) {
    for (let k = 0; k < m; k++) {
      if (arr[i][j][k] === 1) {
        // 익은 토마토라면
        tomato.push([i, j, k, 0]);
      }
      if (arr[i][j][k] === 0) {
        // 익지 않은 토마토라면
        count++;
      }
    }
  }
}

let answer = 0;
let head = 0;
const bfs = () => {
  const queue = [...tomato];
  while (queue.length > head) {
    const [z, y, x, days] = queue[head++];

    for (let i = 0; i < 6; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];
      const nz = z + dz[i];

      if (ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= h) continue;
      if (arr[nz][ny][nx]) continue;

      arr[nz][ny][nx] = 1;
      queue.push([nz, ny, nx, days + 1]);
      count--;
    }
    answer = days;
  }
};

bfs();

console.log(count ? '-1' : answer);