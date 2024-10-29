const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

const diff = Array(N - 1).fill(0);
for (let i = 0; i < N - 1; i++) {
  diff[i] = arr[i + 1] - arr[i];
}

diff.sort((a, b) => a - b);
const answer = diff.slice(0, N - K).reduce((acc, cur) => acc + cur, 0);

console.log(answer);
/**
 * 비용 = 가장 키 큰 원생 - 가장 키 작은 원생
 * 차이가 많이 나는 애들을 끈어서
 */
