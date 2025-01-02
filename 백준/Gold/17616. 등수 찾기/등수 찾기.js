const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M, X] = input[0].split(' ').map(Number);
const graph1 = Array.from({ length: N + 1 }, () => []);
const graph2 = Array.from({ length: N + 1 }, () => []);

for (let i = 0; i < M; i++) {
  const [A, B] = input[i + 1].split(' ').map(Number);
  graph1[A].push(B);
  graph2[B].push(A);
}

const bfs = (graph) => {
  let cnt = 0;
  const queue = [];
  const visited = Array(N + 1).fill(0);

  queue.push(X);
  visited[X] = 1;

  while (queue.length) {
    const cur = queue.shift();

    for (const next of graph[cur]) {
      if (visited[next]) continue;

      visited[next] = 1;
      queue.push(next);
      cnt++;
    }
  }

  return cnt;
};

const maxRank = bfs(graph1);
const minRank = bfs(graph2);

console.log(`${minRank + 1} ${N - maxRank}`);
