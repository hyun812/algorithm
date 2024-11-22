const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const arr = input[1].split(' ').map(Number);

arr.sort((a, b) => a - b);

let answer = [];
let min = Infinity;

for (let i = 0; i < n; i++) {
  const target = arr[i];

  const newArr = [...arr.slice(0, i), ...arr.slice(i + 1)];
  let left = 0;
  let right = n - 2;

  while (left < right) {
    const sum = newArr[left] + newArr[right] + target;

    if (Math.abs(sum) <= min) {
      answer = [target, newArr[left], newArr[right]];
      min = Math.abs(sum);
    }

    if (sum >= 0) {
      right--;
    } else {
      left++;
    }
  }
}

console.log(answer.sort((a, b) => a - b).join(' '));

/**
 *
 * 5
 *
 * -2 6 -97 -6 98
 *
 *
 */