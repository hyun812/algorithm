const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const heights = input[1].split(' ').map(Number);

const check = Array(N + 1).fill(0);
for (let i = 0; i < M; i++) {
  const [a, b, k] = input[i + 2].split(' ').map(Number);

  check[a - 1] += k;
  check[b] -= k;
}

for (let i = 1; i <= N; i++) {
  check[i] += check[i - 1];
}

const answer = heights.map((h, i) => h + check[i]);

console.log(answer.join(' '));