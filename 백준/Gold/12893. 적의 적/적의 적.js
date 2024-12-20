const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);

for (let i = 0; i < M; i++) {
  const [from, to] = input[i + 1].split(' ').map(Number);
  graph[from].push(to);
  graph[to].push(from);
}

let flag = 1;
const visited = Array(N + 1).fill(0);
const dfs = (index, value) => {
  if (!flag) return;

  visited[index] = value;
  for (const next of graph[index]) {
    if (visited[next] === value) {
      flag = 0;
      return;
    }

    if (!visited[next]) {
      value[next] = value * -1;
      dfs(next, value * -1);
    }
  }
};

for (let i = 1; i <= N; i++) {
  if (visited[i]) continue;
  dfs(i, 1);
}
console.log(flag);