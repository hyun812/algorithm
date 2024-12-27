const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M, R] = input[0].split(' ').map(Number);
const board = input.slice(1, N + 1).map((lines) => lines.split(' ').map(Number));
const result = Array.from({ length: N }, () => Array(M).fill('S'));
let answer = 0;
// 상 하 좌 우 (N S W E)
const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const direction = {
  N: 0,
  S: 1,
  W: 2,
  E: 3,
};

const striker = (y, x, d) => {
  let strikerCnt = 0; // 넘어뜨린 도미노 수
  let cnt = board[y][x] - 1; // 넘어 갈 칸 수

  let ny = y;
  let nx = x;
  if (result[ny][nx] === 'S') strikerCnt++;
  result[ny][nx] = 'F';

  while (cnt) {
    ny += dy[direction[d]];
    nx += dx[direction[d]];
    cnt--;

    if (ny < 0 || nx < 0 || ny >= N || nx >= M) break;
    if (result[ny][nx] === 'F') continue;

    result[ny][nx] = 'F';
    strikerCnt++;

    if (board[ny][nx] - 1 > cnt) {
      cnt = board[ny][nx] - 1;
    }
  }

  answer += strikerCnt;
};

const defender = (y, x) => {
  result[y][x] = 'S';
};

for (let i = 1; i <= R * 2; i++) {
  if (i % 2 === 1) {
    const [x, y, d] = input[N + i].trim().split(' ');
    striker(Number(x) - 1, Number(y) - 1, d);
  } else {
    const [x, y] = input[N + i].split(' ').map(Number);
    defender(x - 1, y - 1);
  }
}

console.log(answer);
console.log(result.map((lines) => lines.join(' ')).join('\n'));
