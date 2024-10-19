const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, C] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

const solution = () => {
  if (arr.some((v) => v === C)) {
    return 1;
  }

  arr.sort((a, b) => a - b);

  let left = 0;
  let right = N - 1;
  while (left < right) {
    const sum = arr[left] + arr[right];

    if (sum === C) {
      return 1;
    } else if (sum < C) {
      if (arr.slice(left + 1, right).includes(C - sum)) {
        return 1;
      }
      left++;
    } else if (sum > C) {
      right--;
    }
  }
  return 0;
};

console.log(solution());