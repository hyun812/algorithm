const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const T = +input[0];
let num = 1;
const answer = [];
for (let tc = 0; tc < T; tc++) {
  const N = +input[num];
  const score = input.slice(num + 1, num + N + 1).map((lines) => lines.split(' ').map(Number));

  score.sort((a, b) => a[0] - b[0]);
  let result = 1;
  let top = score[0][1];

  for (let i = 1; i < N; i++) {
    if (score[i][1] >= top) continue;

    top = score[i][1];
    result++;
  }

  answer.push(result);
  num += N + 1;
}

console.log(answer.join('\n'));

/**
 * 성적1, 성적2
 * 다른 지원자보다 떨어지지 않는자는 선발 => 꼴지가 아닌애들
 * 모두 떨어진다면 선발 x
 */
