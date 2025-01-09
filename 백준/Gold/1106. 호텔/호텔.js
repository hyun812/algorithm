const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

/**
 * 고객을 적어도 C명 늘리기 위해 투자해야하는 돈의 최솟값
 * 각 도시의 비용과 그 비용으로 얻을 수 있는 고객의 수
 */

const [C, N] = input[0].split(' ').map(Number);
const cities = input.slice(1).map((lines) => lines.split(' ').map(Number));

// cities.sort((a, b) => a[0] - b[0]);

const dp = Array(C + 1).fill(Infinity);

dp[0] = 0;

for (const city of cities) {
  const [cost, count] = city;
  if (dp[count] > cost) dp[count] = cost;

  for (let i = 1; i <= C; i++) {
    dp[i] = i < count ? Math.min(cost, dp[i]) : Math.min(dp[i - count] + dp[count], dp[i]);
  }
}

console.log(dp[C]);
