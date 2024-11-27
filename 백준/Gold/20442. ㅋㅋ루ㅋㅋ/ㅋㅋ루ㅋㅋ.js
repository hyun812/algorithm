const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const words = input[0];

let cnt = 0;
const lk = [];
for (let i = 0; i < words.length; i++) {
  if (words[i] === 'K') cnt++;
  else lk.push(cnt);
}

cnt = 0;
const rk = [];
for (let i = words.length - 1; i >= 0; i--) {
  if (words[i] === 'K') cnt++;
  else rk.push(cnt);
}

rk.reverse();

let answer = 0;
let left = 0;
let right = rk.length - 1;

while (left <= right) {
  const padding = Math.min(lk[left], rk[right]) * 2;
  answer = Math.max(answer, right - left + 1 + padding);

  if (lk[left] < rk[right]) {
    left++;
  } else {
    right--;
  }
}

console.log(answer);
