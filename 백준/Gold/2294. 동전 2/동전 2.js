const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, k] = input[0].split(' ').map(Number);
const coins = input.slice(1).map(Number);

const dp = Array(k + 1).fill(Infinity);

for (const coin of coins) {
  dp[coin] = 1;
}

for (let i = 1; i <= k; i++) {
  if (dp[i] === 1) continue;

  for (const coin of coins) {
    if (i - coin <= 0) continue;

    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
  }
}

dp[k] === Infinity ? console.log(-1) : console.log(dp[k]);