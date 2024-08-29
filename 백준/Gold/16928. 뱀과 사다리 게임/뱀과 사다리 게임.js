const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

const map = new Array(101).fill(0).map((_, idx) => idx);

for (let i = 1; i <= N + M; i++) {
  let [from, to] = input[i].split(' ').map(Number);
  map[from] = to;
}

const bfs = () => {
  const visited = new Array(101).fill(0);
  const queue = [[1, 0]];
  visited[0] = 1;

  while (queue.length) {
    const [cur, cnt] = queue.shift();

    if (cur === 100) {
      return cnt;
    }

    for (let i = 1; i <= 6; i++) {
      const next = cur + i;

      if (next >= 101) continue;
      if (visited[next]) continue;

      queue.push([map[next], cnt + 1]);
      visited[next] = 1;
    }
  }
};

const count = bfs();

console.log(count);