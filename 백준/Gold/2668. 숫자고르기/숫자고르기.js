const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const arr = [0, ...input.slice(1).map(Number)];
const visited = Array(N + 1).fill(0);

const answer = [];

const dfs = (start, target) => {
  const next = arr[start];

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