const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const arr = [];

for (let i = 0; i < N; i++) {
  arr.push(input[i + 1].split(' ').map(Number));
}

arr.sort((a, b) => (a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]));

let answer = 0;
let start = arr[0][0];
let end = arr[0][1];

for (let i = 1; i < arr.length; i++) {
  const [curS, curE] = arr[i];

  if (curS < end) {
    end = Math.max(end, curE);
  } else {
    answer += end - start;
    start = curS;
    end = curE;
  }
}

answer += end - start;

console.log(answer);
