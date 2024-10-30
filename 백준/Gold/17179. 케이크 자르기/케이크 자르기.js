const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M, L] = input[0].split(' ').map(Number);
const cake = input.slice(1, M + 1).map(Number);
const list = input.slice(M + 1, M + N + 1).map(Number);
const answer = [];

cake.push(L);

// 10 20 35 55 60 70
const check = (mid, count) => {
  let prev = 0;

  for (let i = 0; i <= M; i++) {
    if (cake[i] - prev >= mid) {
      count--;
      prev = cake[i];
    }
  }

  return count < 0;
};

const binarySearch = (count) => {
  let result = 0;
  let left = 0;
  let right = L;

  while (left <= right) {
    // 가장 작은 케이크의 길이
    const mid = Math.floor((left + right) / 2);

    if (check(mid, count)) {
      left = mid + 1;
      result = Math.max(result, mid);
    } else {
      right = mid - 1;
    }
  }

  answer.push(result);
};

list.forEach((count) => {
  binarySearch(count);
});

console.log(answer.join('\n'));
