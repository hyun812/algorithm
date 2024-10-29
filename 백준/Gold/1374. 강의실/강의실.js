const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const arr = [];

for (let i = 0; i < N; i++) {
  const [_, start, end] = input[i + 1].split(' ').map(Number);
  arr.push([start, 1]);
  arr.push([end, -1]);
}

arr.sort((a, b) => (a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]));

let answer = 0;
let sum = 0;
for (const [time, num] of arr) {
  sum += num;
  answer = Math.max(answer, sum);
}
console.log(answer);
