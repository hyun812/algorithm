const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const board = input.slice(1, N + 1).map((lines) => lines.split(' ').map(Number));

const prefix = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));

for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= N; j++) {
    prefix[i][j] = board[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
  }
}

const getPrefixSum = (x1, y1, x2, y2) => {
  return prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
};

const answer = [];
for (let i = N + 1; i < N + M + 1; i++) {
  const position = input[i].split(' ').map(Number);

  answer.push(getPrefixSum(...position));
}

console.log(answer.join('\n'));
