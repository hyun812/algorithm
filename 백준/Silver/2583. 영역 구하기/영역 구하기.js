const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [M, N, K] = input[0].split(' ').map(Number);

const map = Array.from({ length: M }, () => Array(N).fill(0));

for (let i = 0; i < K; i++) {
  const [x1, y1, x2, y2] = input[i + 1].split(' ').map(Number);

  for (let i = y1; i < y2; i++) {
    for (let j = x1; j < x2; j++) {
      map[i][j] = 1;
    }
  }
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const bfs = (i, j) => {
  const queue = [[i, j]];
  let cnt = 0;

  while (queue.length) {
    const [y, x] = queue.shift();
    cnt++;

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
      if (map[ny][nx]) continue;

      queue.push([ny, nx]);
      map[ny][nx] = 1;
    }
  }
  return cnt;
};

const answer = [];
for (let i = 0; i < M; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j]) continue;
    map[i][j] = 1;
    answer.push(bfs(i, j));
  }
}

console.log(answer.length);
console.log(answer.sort((a, b) => a - b).join(' '));
