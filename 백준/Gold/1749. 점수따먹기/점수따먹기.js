const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = [];
for (let i = 1; i <= N; i++) {
  arr.push(input[i].split(' ').map(Number));
}

const preSum = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= M; j++) {
    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + arr[i - 1][j - 1];
  }
}
let answer = -Infinity;

for (let a = 1; a <= N; a++) {
  for (let b = 1; b <= M; b++) {
    for (let c = a; c <= N; c++) {
      for (let d = b; d <= M; d++) {
        const target = preSum[c][d] - preSum[c][b - 1] - preSum[a - 1][d] + preSum[a - 1][b - 1];
        answer = Math.max(answer, target);
      }
    }
  }
}

console.log(answer);