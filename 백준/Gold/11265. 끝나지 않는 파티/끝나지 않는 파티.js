const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const graph = input.slice(1, N + 1).map((lines) => lines.split(' ').map(Number));
const guest = input.slice(N + 1).map((lines) => lines.split(' ').map(Number));

for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (i === j) continue;
      if (graph[i][j] > graph[i][k] + graph[k][j]) {
        graph[i][j] = graph[i][k] + graph[k][j];
      }
    }
  }
}

const answer = [];
const ARRIVE = 'Enjoy other party';
const NOT_ARRIVE = 'Stay here';

guest.forEach(([A, B, C]) => {
  graph[A - 1][B - 1] > C ? answer.push(NOT_ARRIVE) : answer.push(ARRIVE);
});

console.log(answer.join('\n'));