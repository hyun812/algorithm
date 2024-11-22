const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const arr = input[1].split(' ').map(Number);

arr.sort((a, b) => a - b);

let answer = [];
let min = Infinity;

for (let i = 0; i < n - 2; i++) {
  let left = i + 1;
  let right = n - 1;

  while (left < right) {
    const sum = arr[left] + arr[right] + arr[i];

    if (Math.abs(sum) <= min) {
      answer = [arr[i], arr[left], arr[right]];
      min = Math.abs(sum);
    }

    if (sum >= 0) {
      right--;
    } else {
      left++;
    }
  }
}

console.log(answer.join(' '));