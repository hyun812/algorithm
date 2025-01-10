const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const works = input
  .slice(1)
  .map((lines) => lines.split(' ').map(Number))
  .map(([t, s]) => [t, s, s - t])
  .sort((a, b) => b[1] - a[1]);

let answer = works[0][2];
for (let i = 1; i < N; i++) {
  const [t, s, minStartT] = works[i];

  answer = Math.min(answer - t, minStartT);
}

answer < 0 ? console.log(-1) : console.log(answer);