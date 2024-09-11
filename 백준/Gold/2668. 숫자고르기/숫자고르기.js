const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input.shift();
const num = [0, ...input.map(Number)];
const visited = Array(N + 1).fill(0);
const answer = [];

const dfs = (start, target) => {
  const next = num[start];

  if (!visited[next]) {
    visited[next] = 1;
    dfs(next, target);
    visited[next] = 0;
  }

  if (next === target) answer.push(target);
};

for (let i = 1; i <= N; i++) {
  visited[i] = 1;
  dfs(i, i);
  visited[i] = 0;
}

console.log(answer.length);
console.log(answer.join('\n'));