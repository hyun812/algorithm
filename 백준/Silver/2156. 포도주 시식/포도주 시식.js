const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];
const drink = input.slice(1).map(Number);

const dp = Array(n + 1).fill(0);
dp[1] = drink[0];
dp[2] = drink[0] + drink[1];

// 마시지 않은 경우 => dp[i -1];
// 이전꺼와 지금꺼를 마신 경우 => dp[i - 3] + drink[i - 2] + drink[i - 1];
// 이전꺼는 안마시고 지금꺼는 마신 경우 => dp[i - 2] + drink[i - 1];
for (let i = 3; i <= n; i++) {
  dp[i] = Math.max(dp[i - 1], dp[i - 3] + drink[i - 2] + drink[i - 1], dp[i - 2] + drink[i - 1]);
}

console.log(dp[n]);