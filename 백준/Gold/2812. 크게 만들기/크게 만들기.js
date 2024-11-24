const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

let [N, K] = input[0].split(' ').map(Number);
const num = input[1].split('').map(Number);

const stack = [];

for (let i = 0; i < N; i++) {
  const cur = num[i];

  while (stack.length && stack[stack.length - 1] < cur && K) {
    stack.pop();
    K--;
  }

  stack.push(cur);
}

for (let i = 0; i < K; i++) {
  stack.pop();
}

console.log(stack.join(''));
