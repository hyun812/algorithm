const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
let B = input[1].split(' ').map(Number);
const A = Array(N).fill(0);

let answer = 0;

while (true) {
  let count = 0;

  for (let i = 0; i < N; i++) {
    if (B[i] % 2 === 0) continue;

    count++;
    B[i]--;
  }

  if (!count) {
    if (B.every((v) => v === 0)) break;

    B = B.map((v) => v / 2);
    count++;
  }

  answer += count;
}

console.log(answer);
