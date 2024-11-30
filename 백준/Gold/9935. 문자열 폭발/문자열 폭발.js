const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const words = input[0];
const destroy = input[1];
const len = input[1].length;

const stack = [];

for (const char of words) {
  stack.push(char);
  if (stack.length >= len && char === destroy[len - 1]) {
    if (stack.slice(-len).join('') === destroy) {
      stack.splice(-len);
    }
  }
}

const answer = stack.join('').trim();
answer.length ? console.log(answer) : console.log('FRULA');