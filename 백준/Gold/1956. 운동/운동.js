const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

/**
 * 도로의 길이의 합이 가장 작은 사이클
 *
 */
const [V, E] = input[0].split(' ').map(Number);
const graph = Array.from({ length: V }, () => Array(V).fill(Infinity));

for (let i = 0; i < E; i++) {
  const [a, b, c] = input[i + 1].split(' ').map(Number);

  graph[a - 1][b - 1] = c;
}

for (let k = 0; k < V; k++) {
  for (let i = 0; i < V; i++) {
    graph[i][i] = 0;
    for (let j = 0; j < V; j++) {
      if (i === j) continue;
      if (graph[i][j] > graph[i][k] + graph[k][j]) {
        graph[i][j] = graph[i][k] + graph[k][j];
      }
    }
  }
}

let answer = Infinity;
for (let i = 0; i < V; i++) {
  for (let j = 0; j < V; j++) {
    if (i === j) continue;
    if (graph[i][j] !== Infinity && graph[j][i] !== Infinity) {
      answer = Math.min(answer, graph[i][j] + graph[j][i]);
    }
  }
}

console.log(answer === Infinity ? -1 : answer);
