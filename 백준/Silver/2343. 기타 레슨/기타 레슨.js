const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

let left = Math.max(...arr);
let right = arr.reduce((acc, cur) => acc + cur, 0);
let answer = right;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let count = 1;
  let sum = 0;
  for (const v of arr) {
    sum += v;
    if (sum > mid) {
      sum = v;
      count++;
    }
  }

  if (count > M) {
    left = mid + 1;
  } else {
    right = mid - 1;
    answer = Math.min(answer, mid);
  }
}

console.log(answer);