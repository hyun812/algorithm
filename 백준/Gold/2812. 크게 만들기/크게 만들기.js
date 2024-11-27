const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

let [N, K] = input[0].split(' ').map(Number);
const numbers = input[1].split('').map(Number);

const stack = [];
for (let i = 0; i < N; i++) {
  while (stack.length && stack[stack.length - 1] < numbers[i] && K) {
    K--;
    stack.pop();
  }
  stack.push(numbers[i]);
}

while (K--) {
  stack.pop();
}

console.log(stack.join(''));