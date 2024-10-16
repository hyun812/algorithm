const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const snow = input[1].split(' ').map(Number);

/**
 * 서로 다른 4개를 골라서 눈사람 2개를 만듬
 * 두 눈사람의 키 차이가 최소가되는 값을 구해야 함
 */

let answer = Number.MAX_VALUE;
snow.sort((a, b) => a - b);

const solution = () => {
  for (let i = 0; i < N; i++) {
    for (let j = i + 1; j < N; j++) {
      const snowMan1 = snow[i] + snow[j];

      let left = 0;
      let right = N - 1;

      while (left < right) {
        if (left === i || left === j) {
          left++;
          continue;
        }

        if (right === i || right === j) {
          right--;
          continue;
        }

        const snowMan2 = snow[left] + snow[right];

        answer = Math.min(answer, Math.abs(snowMan1 - snowMan2));

        if (snowMan1 > snowMan2) {
          left++;
        } else if (snowMan1 < snowMan2) {
          right--;
        } else {
          answer = 0;
          return;
        }
      }
    }
  }
};

solution();
console.log(answer);