const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [R, C] = input[0].split(' ').map(Number);
const board = input.slice(1).map((lines) => lines.slice(0, C).split(''));

const dy = [-1, 0, 1];
const dx = [1, 1, 1];
let answer = 0;

const dfs = (y, x) => {
  if (flag) return;

  if (x === C - 1) {
    answer++;
    flag = true;
    return;
  }

  for (let i = 0; i < 3; i++) {
    const ny = y + dy[i];
    const nx = x + dx[i];

    if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
    if (board[ny][nx] !== '.') continue;

    if (flag) continue;

    board[ny][nx] = answer;
    dfs(ny, nx);
  }
};

for (let i = 0; i < R; i++) {
  flag = false;
  board[i][0] = answer;
  dfs(i, 0);
}

console.log(answer);