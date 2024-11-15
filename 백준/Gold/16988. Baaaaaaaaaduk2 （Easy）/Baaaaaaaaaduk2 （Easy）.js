const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map((lines) => lines.split(' ').map(Number));
let answer = 0;

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const bfs = (startY, startX, visited) => {
  const queue = [[startY, startX]];
  visited[startY][startX] = 1;

  let deleteCount = 1;
  let zeroFlag = false;
  while (queue.length) {
    const [y, x] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
      if (visited[ny][nx]) continue;
      if (map[ny][nx] === 1) continue;
      if (map[ny][nx] === 0) {
        // 0을 만난다면 돌을 지울 수 없음
        zeroFlag = true;
        continue;
      }

      visited[ny][nx] = 1;
      queue.push([ny, nx]);
      deleteCount++;
    }
  }

  return zeroFlag ? 0 : deleteCount;
};

const deleteCheck = () => {
  const visited = Array.from({ length: N }, () => Array(M).fill(0));
  let cnt = 0;

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] !== 2) continue; // 상대돌이 아니라면
      if (visited[i][j]) continue; // 이미 방문했다면

      cnt += bfs(i, j, visited);
    }
  }
  answer = Math.max(answer, cnt);
};

const dfs = (start, count) => {
  if (count === 2) {
    deleteCheck();
    return;
  }

  for (let i = start; i < N * M; i++) {
    const [y, x] = [Math.floor(i / M), i % M];
    if (map[y][x] !== 0) continue;

    map[y][x] = 1;
    dfs(i + 1, count + 1);
    map[y][x] = 0;
  }
};

dfs(0, 0);

console.log(answer);
