const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const arr = input[1].split(' ').map(Number);

const dp = [...arr];

for (let i = 1; i < N; i++) {
  for (let j = i - 1; j >= 0; j--) {
    if (arr[i] >= arr[j]) continue;

    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
  }
}

console.log(Math.max(...dp));