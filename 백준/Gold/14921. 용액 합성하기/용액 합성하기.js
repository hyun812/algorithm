const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const arr = input[1].split(' ').map(Number);

let left = 0;
let right = n - 1;
let answer = Infinity;

while (left < right) {
  const sum = arr[left] + arr[right];
  const abs_sum = Math.abs(sum);

  if (abs_sum < Math.abs(answer)) {
    answer = sum;
  }

  if (sum < 0) {
    left++;
  } else {
    right--;
  }
}

console.log(answer);
