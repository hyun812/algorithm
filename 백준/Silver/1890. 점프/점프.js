const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];
const board = input.slice(1).map((lines) => lines.split(' ').map(Number));

const dy = [1, 0];
const dx = [0, 1];

const dp = Array.from({ length: n }, () => Array(n).fill(BigInt(0)));

const outOfIndex = (y, x) => {
  if (y < 0 || x < 0 || y >= n || x >= n) return false;
  return true;
};

dp[0][0] = BigInt(1);

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    const num = board[i][j];

    if (!num) break;

    for (let k = 0; k < 2; k++) {
      const ny = i + dy[k] * num;
      const nx = j + dx[k] * num;

      if (!outOfIndex(ny, nx)) continue;

      dp[ny][nx] += dp[i][j];
    }
  }
}

console.log(dp[n - 1][n - 1].toString());
