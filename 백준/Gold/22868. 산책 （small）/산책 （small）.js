const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
let visited = Array(N + 1).fill(0);
const [S, E] = input[M + 1].split(' ').map(Number);

for (let i = 1; i < M + 1; i++) {
  const [from, to] = input[i].split(' ').map(Number);

  graph[from].push(to);
  graph[to].push(from);
}

graph.map((v) => v.sort((a, b) => a - b));

const bfs = (start, end) => {
  const queue = [];

  queue.push([start, 0, '']);
  visited[start] = 1;

  while (queue.length) {
    const [cur, len, path] = queue.shift();

    if (cur === end) {
      return [len, path];
    }

    for (const next of graph[cur]) {
      if (visited[next]) continue;

      queue.push([next, len + 1, `${path} ${next}`]);
      visited[next] = 1;
    }
  }
};

const [len, path2] = bfs(S, E);
visited = Array(N + 1).fill(0);
path2.split(' ').forEach((v) => (visited[v] = 1));

console.log(len + bfs(E, S)[0]);