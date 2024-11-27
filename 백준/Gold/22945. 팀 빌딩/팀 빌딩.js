const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = input[0];
const abilities = input[1].split(' ').map(Number);

let answer = 0;
let left = 0;
let right = n - 1;

while (left < right) {
  const min = Math.min(abilities[left], abilities[right]);
  const developerCount = right - left - 1;

  answer = Math.max(min * developerCount, answer);
  if (abilities[left] < abilities[right]) {
    left++;
  } else {
    right--;
  }
}

console.log(answer);
