const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const T = +input[0];
let num = 1;
let visited = Array(11).fill(0);
let ability = [];
let answer = [];
let max = 0;

const dfs = (pos, score) => {
  if (pos === 11) {
    max = Math.max(max, score);
    return;
  }

  for (let i = 0; i < 11; i++) {
    if (!ability[pos][i]) continue;
    if (visited[i]) continue;

    visited[i] = 1;
    dfs(pos + 1, score + ability[pos][i]);
    visited[i] = 0;
  }
};

for (let tc = 0; tc < T; tc++) {
  for (let i = 0; i < 11; i++) {
    ability.push(input[num + i].split(' ').map(Number));
  }

  dfs(0, 0, 0);

  answer.push(max);

  ability = [];
  visited = Array(11).fill(0);
  num += 11;
  max = 0;
}

console.log(answer.join('\n'));