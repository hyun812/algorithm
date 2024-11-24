const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const balloons = input[1].split(' ').map(Number);
const arrow = Array(1000001).fill(0);

let answer = 0;

for (const h of balloons) {
  if (arrow[h] > 0) {
    arrow[h]--;
    arrow[h - 1]++;
  } else {
    answer++;
    arrow[h - 1]++;
  }
}

console.log(answer);