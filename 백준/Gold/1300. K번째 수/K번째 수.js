const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const K = +input[1];

const binarySearch = () => {
  let left = 1;
  let right = N * N;
  let ans = N * N;
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    let sum = 0;
    for (let i = 1; i <= N; i++) {
      let target = mid / i > N ? N : Math.floor(mid / i); // 행을 기준으로
      sum += target;
    }

    if (sum >= K) {
      right = mid - 1;
      ans = Math.min(ans, mid);
    } else {
      left = mid + 1;
    }
  }
  return ans;
};

console.log(binarySearch());