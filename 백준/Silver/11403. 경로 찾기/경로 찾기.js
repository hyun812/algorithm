const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [N, ...input] = fs.readFileSync(filePath).toString().trim().split('\n');

const graph = input.slice().map((v) => v.split(' ').map(Number));

for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (graph[i][k] === 1 && graph[k][j] === 1) {
        graph[i][j] = 1;
      }
    }
  }
}

for (let i = 0; i < N; i++) {
  console.log(graph[i].join(' '));
}
