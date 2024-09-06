const lowerBound = (arr, target) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    const mid = Math.floor((left + right) / 2);

    if (arr[mid] >= target) right = mid;
    else left = mid + 1;
  }

  return left;
};

const upperBound = (arr, target) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    const mid = Math.floor((left + right) / 2);

    if (arr[mid] > target) right = mid;
    else left = mid + 1;
  }

  return right;
};

// console.log(lowerBound(arr, 3)); // 처음으로 나오는 인덱스
// console.log(upperBound(arr, 3)); // 초과하는 인덱스 반환

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

let left = 0;
let right = 1000000000;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let sum = 0;
  arr.forEach((v) => {
    sum += v <= mid ? 0 : v - mid;
  });

  if (sum < M) {
    right = mid - 1;
  } else {
    left = mid + 1;
  }
}

console.log(right);