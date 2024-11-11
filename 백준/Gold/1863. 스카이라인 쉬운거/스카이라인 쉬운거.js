const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const skylines = input.slice(1).map((v) => v.split(' ').map(Number));

skylines.sort((a, b) => a[0] - b[0]);

let answer = 0;
const stack = [];
for (let i = 0; i < n; i++) {
  while (stack[stack.length - 1] > skylines[i][1]) {
    answer++;
    stack.pop();
  }

  if (skylines[i][1] > 0 && (stack.length === 0 || stack[stack.length - 1] < skylines[i][1])) {
    stack.push(skylines[i][1]);
  }
}

answer += stack.length;

console.log(answer);