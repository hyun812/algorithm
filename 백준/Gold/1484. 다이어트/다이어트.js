/**
 * 현재 몸무게의 제곱 - 기억하고 있던 몸무게의 제곱 = G
 *  현재 몸무게로 가능한 것을 모두 출력
 */
const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const answer = [];
const G = +input[0];
const powArr = new Array(100001).fill(0).map((_, i) => i * i);

let left = 1; // 기억하고 있던 몸무게 인덱스
let right = 2; // 현재 몸무게 인덱스

while (right < 100000) {
  const weight = powArr[right] - powArr[left];

  if (weight === G) {
    answer.push(right);
  }

  if (weight > G) {
    left++;
  } else {
    right++;
  }
}

console.log(answer.length ? answer.join('\n') : -1);