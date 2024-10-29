const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const T = +input[0];
const dp = Array.from({ length: 65 }, () => Array(10).fill(0));

for (let i = 0; i <= 9; i++) {
  dp[1][i] = 1;
}

for (let k = 2; k <= 64; k++) {
  for (let i = 0; i <= 9; i++) {
    for (let j = i; j <= 9; j++) {
      dp[k][i] += dp[k - 1][j];
    }
  }
}

const answer = [];
for (let tc = 0; tc < T; tc++) {
  const n = +input[tc + 1];

  const result = dp[n].reduce((acc, cur) => acc + cur, 0);
  answer.push(result);
}
console.log(answer.join('\n'));
