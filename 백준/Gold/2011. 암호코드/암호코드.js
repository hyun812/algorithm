const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const password = input[0];

const dp = Array(password.length + 1).fill(0);
const MOD = 1000000;

dp[0] = 1;
dp[1] = 1;

const solution = () => {
  if (password[0] === '0') return 0;

  for (let i = 2; i < dp.length; i++) {
    const now = +password[i - 1];
    const prev = +password[i - 2];

    if (now !== 0) {
      dp[i] += dp[i - 1] % MOD;
    }

    const temp = prev * 10 + now;
    if (temp >= 10 && temp <= 26) {
      dp[i] += dp[i - 2] % MOD;
    }
  }

  return dp[dp.length - 1] % MOD;
};

console.log(solution());