/**
 * 휴게소 M개를 더 지어서 휴게소가 없는 구간의 길이의 최대값을 최소로
 * N : 현재 휴게소의 개수
 * M : 더 지으려는 휴게소의 개수
 * L : 고속도로의 길이
 *
 * 구간의 길이를 기준으로 이분탐색?
 * mid길이가 최대값이 되도록 휴게소를 설치 후 그 개수를 비교하면되겠다!!
 *
 * 0 10 512
 *
 * 47 94 141 188 235 282 329 376 423 470
 */

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M, L] = input[0].split(' ').map(Number);
const locations = N ? [0, ...input[1].split(' ').map(Number), L] : [0, L];

locations.sort((a, b) => a - b);

const getRestAreaCountByMaxLength = (mid) => {
  let count = 0;

  for (let i = 1; i < locations.length; i++) {
    const diff = locations[i] - locations[i - 1] - 1;
    count += Math.floor(diff / mid);
  }

  return count;
};

let answer = Infinity;
const binarySearch = () => {
  let left = 1;
  let right = L - 1;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    const count = getRestAreaCountByMaxLength(mid);

    if (count <= M) {
      right = mid - 1;
      answer = Math.min(answer, mid);
    } else {
      left = mid + 1;
    }
  }
};

binarySearch();

console.log(answer);