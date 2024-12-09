const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const words = input[1];

const alpha = new Map();

let left = 0;
let right = 0;
let answer = 0;

while (left <= right && right < words.length) {
  alpha.set(words[right], (alpha.get(words[right]) || 0) + 1);

  while (alpha.size > N) {
    if (alpha.get(words[left]) === 1) {
      alpha.delete(words[left]);
    } else {
      alpha.set(words[left], alpha.get(words[left]) - 1);
    }
    left++;
  }

  answer = Math.max(answer, right - left + 1);
  right++;
}

console.log(answer);
