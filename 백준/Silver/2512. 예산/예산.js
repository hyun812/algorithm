const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [n, ...arr] = fs.readFileSync(filePath).toString().trim().split(/\s+/).map(Number);

const m = arr.pop();

arr.sort((a, b) => a - b);

const binarySearch = () => {
  let left = 0;
  let right = arr[n - 1];

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    let sum = 0;
    for (let i = 0; i < n; i++) {
      sum += arr[i] > mid ? mid : arr[i];
    }

    if (sum > m) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return right;
};

console.log(binarySearch());