/**
 * N * N 격자
 * M개의 바이러스를 활성 상태로 변경하고자 함
 * 0: 빈칸, 1: 벽, 2: 바이러스
 * 바이러스 => 활성 상태인 경우 상하좌우 모든 빈칸으로 복제
 * 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간
 */

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const board = input.slice(1).map((lines) => lines.split(' ').map(Number));

const virus = [];
let empty = 0;
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (board[i][j] === 2) {
      virus.push([i, j]);
    } else if (board[i][j] === 0) {
      empty++;
    }
  }
}

const comb = (arr, num) => {
  if (num === 1) return arr.map((el) => [el]);

  const results = [];

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = comb(rest, num - 1);
    const attached = combinations.map((el) => [fixed, ...el]);

    results.push(...attached);
  });

  return results;
};

const combinations = comb(virus, M);
const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
let answer = Infinity;

const bfs = (start) => {
  const queue = [];
  const visited = Array.from({ length: N }, () => Array(N).fill(0));

  start.forEach(([y, x]) => {
    queue.push([y, x, 0]);
    visited[y][x] = 1;
  });

  let cnt = 0;
  while (queue.length) {
    const [y, x, time] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if (visited[ny][nx]) continue;
      if (board[ny][nx] === 1) continue;

      if (board[ny][nx] === 0) {
        cnt++;
      }

      if (cnt === empty) {
        answer = Math.min(answer, time + 1);
        return;
      }

      queue.push([ny, nx, time + 1]);
      visited[ny][nx] = 1;
    }
  }
};

if (empty === 0) {
  console.log(0);
} else {
  combinations.forEach((v) => bfs(v));
  answer === Infinity ? console.log(-1) : console.log(answer);
}