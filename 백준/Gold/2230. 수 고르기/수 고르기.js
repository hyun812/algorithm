const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = new Array(N);

for (let i = 0; i < N; i++) {
  arr[i] = +input[i + 1];
}

arr.sort((a, b) => a - b);

let answer = Infinity;
let left = 0;
let right = 0;

while (left <= right && right < N) {
  const result = arr[right] - arr[left];

  if (result >= M) {
    left++;
    answer = Math.min(answer, result);
  } else {
    right++;
  }
}

console.log(answer);