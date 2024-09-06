const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [M, N] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

let left = 0;
let right = 1000000000;
let answer = 1000000000;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let count = 0;
  arr.forEach((v) => {
    count += v < mid ? 0 : Math.floor(v / mid);
  });
  if (count >= M) {
    left = mid + 1;
  } else {
    right = mid - 1;
    answer = Math.min(answer, mid - 1);
  }
}

console.log(answer);