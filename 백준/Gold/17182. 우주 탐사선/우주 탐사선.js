const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const graph = input.slice(1).map((lines) => lines.split(' ').map(Number));

for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (i === j) continue;
      graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    }
  }
}

const visited = Array(N).fill(0);
let answer = Infinity;
const dfs = (pos, cnt, time) => {
  if (answer <= time) return;

  if (cnt === N) {
    answer = Math.min(answer, time);
    return;
  }

  for (let i = 0; i < N; i++) {
    if (visited[i]) continue;

    visited[i] = 1;
    dfs(i, cnt + 1, time + graph[pos][i]);
    visited[i] = 0;
  }
};

dfs(K, 0, 0);

console.log(answer);
