const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const jumps = Array.from({ length: Math.max(N, 4) }, () => Array(2).fill(0));

for (let i = 1; i <= N - 1; i++) {
  const [s, l] = input[i].split(' ').map(Number);
  jumps[i][0] = s;
  jumps[i][1] = l;
}
const K = +input[N];
const dp = Array.from({ length: Math.max(N + 1, 4) }, () => Array(2).fill(Infinity));

// 첫 번째 -> 돌 위치
// 두 번째 -> 매우 큰 점프 사용 유무
dp[0][0] = 0;
dp[0][1] = 0;
dp[1][0] = 0;
dp[1][1] = 0;
dp[2][0] = jumps[1][0];
dp[3][0] = Math.min(dp[2][0] + jumps[2][0], dp[1][0] + jumps[1][1]);

for (let i = 4; i <= N; i++) {
  dp[i][0] = Math.min(dp[i - 1][0] + jumps[i - 1][0], dp[i - 2][0] + jumps[i - 2][1]);
  dp[i][1] = Math.min(dp[i - 1][1] + jumps[i - 1][0], dp[i - 2][1] + jumps[i - 2][1], dp[i - 3][0] + K);
}

console.log(Math.min(dp[N][0], dp[N][1]));