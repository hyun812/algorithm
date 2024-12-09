const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];

const getPrimeArray = (n) => {
  const arr = Array(n).fill(1);

  arr[0] = 0;
  arr[1] = 0;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (!arr[i]) continue;

    for (let j = i * i; j <= n; j += i) {
      arr[j] = 0;
    }
  }

  return arr.map((v, i) => v && i).filter((v) => v);
};

const arr = getPrimeArray(N + 1);

let left = 0;
let right = 0;
let sum = 0;
let answer = 0;

while (true) {
  if (sum === N) {
    answer++;
    sum -= arr[left++];
  } else if (sum > N) {
    sum -= arr[left++];
  } else {
    if (right === arr.length) break;
    sum += arr[right++];
  }
}

console.log(answer);