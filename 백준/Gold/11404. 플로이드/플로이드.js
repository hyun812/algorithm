const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input.shift();
const M = +input.shift();

const graph = Array.from({ length: N }, () => Array(N).fill(Infinity));

for (let i = 0; i < M; i++) {
  const [from, to, cost] = input[i].split(' ').map(Number);

  graph[from - 1][to - 1] = Math.min(graph[from - 1][to - 1], cost);
}

for (let i = 0; i < N; i++) {
  graph[i][i] = 0;
}

for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (graph[i][j] > graph[i][k] + graph[k][j]) {
        graph[i][j] = graph[i][k] + graph[k][j];
      }
    }
  }
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (graph[i][j] === Infinity) {
      graph[i][j] = 0;
    }
  }
}

console.log(graph.map((arr) => arr.join(' ')).join('\n'));