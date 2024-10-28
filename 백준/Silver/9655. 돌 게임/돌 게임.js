const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const dp = Array(N + 1).fill(0);

dp[1] = 1;
dp[2] = 2;
dp[3] = 1;

for (let i = 4; i <= N; i++) {
  dp[i] = Math.min(dp[i - 3] + 1, dp[i - 1] + 1);
}

const answer = dp[N] % 2 === 0 ? 'CY' : 'SK';
console.log(answer);