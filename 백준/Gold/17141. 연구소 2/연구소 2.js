const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

/**
 * 0: 빈칸
 * 1: 벽
 * 2: 바이러스
 *
 * 바이러스는 인접한 모든 빈 칸으로 복제
 */

const [N, M] = input[0].split(' ').map(Number);
const board = input.slice(1, 1 + N).map((lines) => lines.split(' ').map(Number));

const virus = [];
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (board[i][j] !== 2) continue;
    virus.push([i, j]);
    board[i][j] = 0;
  }
}

const getCombinations = (arr, selectNum) => {
  if (selectNum === 1) return arr.map((v) => [v]);

  const results = [];
  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, selectNum - 1);
    const attached = combinations.map((e) => [fixed, ...e]);

    results.push(...attached);
  });

  return results;
};

const arr = Array(virus.length)
  .fill(0)
  .map((_, i) => i);

const comb = getCombinations(arr, M);

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const bfs = (board, queue, visited) => {
  let minTime = 0;

  while (queue.length) {
    const [y, x, time] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if (visited[ny][nx]) continue;
      if (board[ny][nx] === 1) continue;

      visited[ny][nx] = 1;
      queue.push([ny, nx, time + 1]);
      minTime = Math.max(minTime, time + 1);
      board[ny][nx] = 2;
    }
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (board[i][j] === 0) return -1;
    }
  }

  return minTime;
};

let answer = Infinity;
comb.forEach((v) => {
  const copy = board.map((v) => v.slice());
  const queue = [];
  const visited = Array.from({ length: N }, () => Array(N).fill(0));

  v.forEach((i) => {
    const [y, x] = virus[i];
    copy[y][x] = 2;
    queue.push([y, x, 0]);
    visited[y][x] = 1;
  });

  const time = bfs(copy, queue, visited);

  if (time !== -1) {
    answer = Math.min(answer, time);
  }
});

answer === Infinity ? console.log(-1) : console.log(answer);