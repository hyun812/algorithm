const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input.shift().split(' ').map(Number);

const graph = input.map((v) => v.split('').map(Number));

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const bfs = () => {
  const queue = [];
  const visited = Array.from({ length: N }, () => Array(M).fill(0));

  queue.push([0, 0, 1]);

  while (queue.length) {
    const [y, x, len] = queue.shift();

    if (y === N - 1 && x === M - 1) {
      return len;
    }

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
      if (!graph[ny][nx]) continue;
      if (visited[ny][nx]) continue;

      visited[ny][nx] = 1;
      queue.push([ny, nx, len + 1]);
    }
  }
};

const answer = bfs();
console.log(answer);