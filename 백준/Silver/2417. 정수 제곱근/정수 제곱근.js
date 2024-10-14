const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];

let left = 0;
let right = n;
let answer = n;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);

  if (Math.pow(mid, 2) >= n) {
    right = mid - 1;
    answer = Math.min(answer, mid);
  } else {
    left = mid + 1;
  }
}

console.log(answer);