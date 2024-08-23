const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [n, m, ...arr] = fs.readFileSync(filePath).toString().trim().split(/\s+/).map(Number);

arr.sort((a, b) => a - b);

const binarySearch = () => {
  let left = BigInt(1);
  let right = BigInt(arr[n - 1] * m);

  while (left < right) {
    let mid = BigInt((left + right) / 2n);

    // mid 시간에 받을 수 있는 사람 수
    let cnt = BigInt(0);
    for (let i = 0; i < n; i++) {
      cnt += BigInt(mid / BigInt(arr[i]));
    }

    if (cnt >= m) {
      right = mid;
    } else {
      left = mid + BigInt(1);
    }
  }
  return right;
};

console.log(String(binarySearch()));