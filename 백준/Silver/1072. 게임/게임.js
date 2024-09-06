const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [X, Y] = input[0].split(' ').map(Number);
const Z = Math.floor((Y * 100) / X);

let left = 0;
let right = 1e9;
let answer = -1;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let calc = Math.floor(((Y + mid) * 100) / (X + mid));

  if (calc !== Z) {
    answer = mid;
    right = mid - 1;
  } else {
    left = mid + 1;
  }
}

console.log(answer);