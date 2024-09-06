const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const A = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);
const M = +input[2];
const arr = input[3].split(' ').map(Number);

const binarySearch = (target) => {
  let left = 0;
  let right = N - 1;

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);

    if (A[mid] < target) {
      left = mid + 1;
    } else if (A[mid] === target) {
      return 1;
    } else if (A[mid] > target) {
      right = mid - 1;
    }
  }

  return 0;
};

const answer = [];
arr.forEach((v) => {
  answer.push(binarySearch(v));
});

console.log(answer.join('\n'));