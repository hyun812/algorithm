const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const works = input
  .slice(1)
  .map((lines) => lines.split(' ').map(Number))
  .sort((a, b) => b[1] - a[1]);

let answer = works[0][1] - works[0][0];
for (let i = 1; i < N; i++) {
  const [t, s] = works[i];

  answer = Math.min(answer - t, s - t);
}

answer < 0 ? console.log(-1) : console.log(answer);