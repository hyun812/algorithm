const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const shortGraph = Array.from({ length: N + 1 }, () => []);
const tallGraph = Array.from({ length: N + 1 }, () => []);

for (let i = 0; i < M; i++) {
  const [from, to] = input[i + 1].split(' ').map(Number);

  shortGraph[from].push(to);
  tallGraph[to].push(from);
}

const dfs = (start, graph) => {
  const queue = [[start]];
  const visited = Array(N + 1).fill(0);

  visited[start] = 1;

  while (queue.length) {
    const [cur] = queue.shift();

    for (const next of graph[cur]) {
      if (visited[next]) continue;
      visited[next] = 1;
      queue.push([next]);
    }
  }

  return visited;
};

let answer = 0;
for (let i = 1; i <= N; i++) {
  const short = dfs(i, shortGraph);
  const tall = dfs(i, tallGraph);

  const sum = short.map((v, i) => v + tall[i]);

  sum.shift();

  if (sum.every((v) => v !== 0)) answer++;
}

console.log(answer);