const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const objects = input.slice(1).map((line) => line.split(' ').map(Number));

objects.sort((a, b) => a[1] - b[1]);
const dp = Array.from({ length: N + 1 }, () => Array(K + 1).fill(0));

for (let i = 1; i <= N; i++) {
  const [w, v] = objects[i - 1];
  for (let j = 1; j <= K; j++) {
    if (j - w >= 0) {
      dp[i][j] = Math.max(dp[i - 1][j - w] + v, dp[i - 1][j]);
    } else {
      dp[i][j] = dp[i - 1][j];
    }
  }
}

console.log(dp[N][K]);

/**
 * 해당 물건을 넣을 수 있는 그 전 무게 + 가치 vs 비교
 *
 *
 */