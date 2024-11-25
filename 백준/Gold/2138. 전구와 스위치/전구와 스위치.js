const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const result = input[2].split('').map(Number);

const cur = input[1].slice(0, N).split('').map(Number);
const cur2 = cur.slice();

cur2[0] = 1 - cur2[0];
cur2[1] = 1 - cur2[1];

const solution = (arr) => {
  let cnt = 0;

  for (let i = 0; i < N - 1; i++) {
    if (arr[i] === result[i]) continue;

    cnt++;
    arr[i] = 1 - arr[i];
    arr[i + 1] = 1 - arr[i + 1];
    if (i + 2 !== N) {
      arr[i + 2] = 1 - arr[i + 2];
    }
  }

  return arr[N - 1] !== result[N - 1] ? -1 : cnt;
};

const answer1 = solution(cur);
let answer2 = solution(cur2);
if (answer2 !== -1) answer2++;

if (answer1 === -1) console.log(answer2);
else if (answer2 === -1) console.log(answer1);
else console.log(Math.min(answer1, answer2));