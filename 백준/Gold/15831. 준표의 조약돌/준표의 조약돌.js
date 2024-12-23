const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

/**
 * 까만색 조약돌은 B개 이하로
 * 흰색 조약돌은 W개 이상으로
 * 가장 긴 구간의 길이
 */

const [N, B, W] = input[0].split(' ').map(Number);
const stones = input[1].split('');

let answer = 0;

let left = 0;
let right = 0;

let black = 0;
let white = 0;

while (right < N) {
  if (black > B) {
    stones[left] === 'B' ? black-- : white--;
    left++;
  } else {
    stones[right] === 'B' ? black++ : white++;
    right++;
  }

  if (black <= B && white >= W) {
    answer = Math.max(answer, right - left);
  }
}

console.log(answer);