const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const height = new Array(367).fill(0);

for (let i = 0; i < N; i++) {
  const [start, end] = input[i + 1].split(' ').map(Number);
  for (let j = start; j <= end; j++) {
    height[j]++;
  }
}

let answer = 0;
let h = 0;
let w = 0;

for (let i = 1; i < height.length; i++) {
  if (height[i] === 0) {
    answer += w * h;
    w = 0;
    h = 0;
    continue;
  }

  h = Math.max(h, height[i]);
  w++;
}

console.log(answer);