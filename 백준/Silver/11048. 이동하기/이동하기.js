const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map((line) => line.split(' ').map(Number));

const dp = Array.from({ length: N }, () => Array(M).fill(0));

dp[0][0] = map[0][0];

for (let i = 1; i < N; i++) {
  dp[i][0] = dp[i - 1][0] + map[i][0];
}

for (let i = 1; i < M; i++) {
  dp[0][i] = dp[0][i - 1] + map[0][i];
}

for (let i = 1; i < N; i++) {
  for (let j = 1; j < M; j++) {
    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + map[i][j];
  }
}

console.log(dp[N - 1][M - 1]);