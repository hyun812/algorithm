const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const T = +input[0];
let num = 1;
const answer = [];
for (let tc = 0; tc < T; tc++) {
  const n = +input[num];
  const board = input.slice(num + 1, num + 3).map((lines) => lines.split(' ').map(Number));

  const dp = Array.from({ length: n }, () => Array(2).fill(0));

  dp[0][0] = board[0][0];
  dp[0][1] = board[1][0];

  if (n === 1) {
    answer.push(Math.max(dp[0][0], dp[0][1]));
  } else {
    dp[1][0] = board[0][1] + board[1][0];
    dp[1][1] = board[0][0] + board[1][1];

    for (let i = 2; i < n; i++) {
      dp[i][0] = Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 1][1]) + board[0][i];
      dp[i][1] = Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 1][0]) + board[1][i];
    }

    answer.push(Math.max(dp[n - 1][0], dp[n - 1][1]));
  }
  num += 3;
}

console.log(answer.join('\n'));