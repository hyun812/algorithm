const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const arr = input[1].split(' ').map(Number);

const dp = [...arr];

for (let i = 1; i < n; i++) {
  dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
}

const dp2 = [...arr];
for (let i = 1; i < n; i++) {
  dp2[i] = Math.max(dp[i - 1], arr[i] + dp2[i - 1]);
}

const dpMax = Math.max(...dp);
const dp2Max = Math.max(...dp2);

console.log(Math.max(dpMax, dp2Max));
