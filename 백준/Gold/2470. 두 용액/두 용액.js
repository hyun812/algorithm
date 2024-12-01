const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const arr = input[1].split(' ').map(Number);

arr.sort((a, b) => a - b);

let [a, b] = [0, 0];
const binarySearch = (n, arr) => {
  let left = 0;
  let right = n - 1;
  let min = Infinity;

  while (left < right) {
    const sum = arr[left] + arr[right];
    const absSum = Math.abs(arr[left] + arr[right]);

    if (min > absSum) {
      min = absSum;
      a = arr[left];
      b = arr[right];
    }

    if (sum < 0) {
      left++;
    } else {
      right--;
    }
  }
};

binarySearch(N, arr);
console.log(a, b);