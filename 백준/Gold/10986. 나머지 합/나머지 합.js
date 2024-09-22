const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

const sum = [arr[0]];
for (let i = 1; i < N; i++) {
  sum[i] = sum[i - 1] + arr[i];
}

const mod = sum.map((v) => v % M);
const count = Array(M).fill(0);

for (let i = 0; i < N; i++) {
  count[mod[i]]++;
}

let answer = count[0];
for (let i = 0; i < M; i++) {
  answer += Math.floor((count[i] * (count[i] - 1)) / 2);
}

console.log(answer);