const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

/**
 * 등장횟수가 커지는 순
 * 등장횟수가 같다면 수가 커지는 순으로
 * 0은 무시
 * 100 개를 넘어가는 경우 나머지는 버림
 */

const [r, c, k] = input[0].split(' ').map(Number);
const board = Array.from({ length: 100 }, () => Array(100).fill(0));
for (let i = 0; i < 3; i++) {
  const row = input[i + 1].split(' ').map(Number);
  for (let j = 0; j < 3; j++) {
    board[i][j] = row[j];
  }
}

let n = 3;
let m = 3;
let answer = 0;
while (true) {
  if (board[r - 1][c - 1] === k) break;
  if (answer > 100) {
    answer = -1;
    break;
  }

  if (n >= m) RCalc();
  else CCalc();
  answer++;
}

console.log(answer);

function RCalc() {
  let tempSize = m;
  for (let i = 0; i < n; i++) {
    const check = new Map();

    for (let j = 0; j < m; j++) {
      if (board[i][j] === 0) continue;
      check.set(board[i][j], (check.get(board[i][j]) || 0) + 1);
      board[i][j] = 0;
    }

    const temp = Array.from(check)
      .sort((a, b) => (a[1] === b[1] ? a[0] - b[0] : a[1] - b[1]))
      .flat();

    const size = Math.min(100, temp.length);

    for (let j = 0; j < size; j++) {
      board[i][j] = temp[j];
    }

    tempSize = Math.max(tempSize, size);
  }
  m = tempSize;
}

function CCalc() {
  let tempSize = n;
  for (let i = 0; i < m; i++) {
    const check = new Map();

    for (let j = 0; j < n; j++) {
      if (board[j][i] === 0) continue;
      check.set(board[j][i], (check.get(board[j][i]) || 0) + 1);
      board[j][i] = 0;
    }

    const temp = Array.from(check)
      .sort((a, b) => (a[1] === b[1] ? a[0] - b[0] : a[1] - b[1]))
      .flat();

    const size = Math.min(100, temp.length);
    for (let j = 0; j < size; j++) {
      board[j][i] = temp[j];
    }

    tempSize = Math.max(tempSize, size);
  }
  n = tempSize;
}
