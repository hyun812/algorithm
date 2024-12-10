const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0]; // 회원 수
const friendScore = Array.from({ length: n + 1 }, () => Array(n + 1).fill(Infinity));
let num = 1;

while (true) {
  const [from, to] = input[num].split(' ').map(Number);

  if (from === -1 && to === -1) break;

  friendScore[from][to] = 1;
  friendScore[to][from] = 1;

  num++;
}

for (let k = 1; k <= n; k++) {
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
      if (i === j) {
        friendScore[i][j] = 0;
        continue;
      }

      if (friendScore[i][j] > friendScore[i][k] + friendScore[k][j])
        friendScore[i][j] = friendScore[i][k] + friendScore[k][j];
    }
  }
}

let minScore = Infinity;
let scoreArr = Array(n + 1).fill(0);
for (let i = 1; i <= n; i++) {
  let score = 0;
  for (let j = 1; j <= n; j++) {
    score = Math.max(score, friendScore[i][j]);
  }

  scoreArr[i] = score;
  minScore = Math.min(minScore, score);
}

const answer = scoreArr.map((v, i) => (v === minScore ? i : -1)).filter((v) => v !== -1);

console.log(minScore, answer.length);
console.log(answer.join(' '));
