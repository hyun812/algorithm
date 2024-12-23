const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const dist = input.slice(1).map(Number);
const sum = dist.reduce((acc, cur) => acc + cur, 0);

let left = 0;
let right = 0;

let answer = 0;
let now = dist[left];

while (left <= right && right < N) {
  const minLen = Math.min(now, sum - now);

  answer = Math.max(answer, minLen);

  if (now === minLen) {
    right++;
    now += dist[right];
  } else {
    now -= dist[left];
    left++;
  }
}

console.log(answer);
