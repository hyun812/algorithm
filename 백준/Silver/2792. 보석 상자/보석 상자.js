const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

/**
 * N: 아이들의 수
 * M: 색상의 수
 *
 * 모든 보석을 N명의 학생들에게 나누어주려고 함
 * 보석을 받지 못하는 학생 ok
 * 학생은 항상 같은 색상의 보석만 가져감
 *
 * 질투심: 가장 많은 보석을 가져간 학생이 가지고 있는 보석의 개수
 */

const jewel = [];
for (let i = 1; i <= M; i++) {
  jewel.push(+input[i]);
}

// 보석의 개수를 기준으로 이분탐색
// 그 보석의 개수를 기반으로 아이들의 수를 구함
// 그 아이들의 수가 작으면? 크면? 해서 다시 이분탐색

let left = 0;
let right = jewel.reduce((acc, cur) => acc + cur, 0);
let answer = right;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);

  let peopleCount = 0;

  jewel.forEach((v) => {
    peopleCount += (v % mid > 0 && 1) + Math.floor(v / mid);
  });

  if (peopleCount <= N) {
    right = mid - 1;
    answer = Math.min(answer, mid);
  } else {
    left = mid + 1;
  }
}

console.log(answer);
