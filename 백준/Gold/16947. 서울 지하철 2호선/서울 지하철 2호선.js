const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const graph = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= N; i++) {
  const [from, to] = input[i].split(' ').map(Number);

  graph[from].push(to);
  graph[to].push(from);
}

const checkCycle = (start, cur, len, visited) => {
  visited[cur] = 1;
  for (const next of graph[cur]) {
    if (!visited[next]) {
      if (checkCycle(start, next, len + 1, visited)) return true;
    } else {
      if (len >= 3 && start === next) return true;
    }
  }
  visited[cur] = 0;
  return false;
};

const bfs = (start, dist) => {
  const queue = [[start, 0]];
  const visited = Array(N + 1).fill(0);

  visited[start] = 1;

  while (queue.length) {
    const [node, len] = queue.shift();

    if (dist[node] === 0) {
      dist[start] = len;
      return;
    }

    for (const next of graph[node]) {
      if (visited[next]) continue;

      visited[next] = 1;
      queue.push([next, len + 1]);
    }
  }
};

for (let i = 1; i <= N; i++) {
  const visited = Array(N + 1).fill(0);
  if (checkCycle(i, i, 1, visited)) {
    const dist = visited.slice().map((v) => (v === 1 ? 0 : -1));

    for (let i = 1; i <= N; i++) {
      if (!dist[i]) continue;
      bfs(i, dist);
    }

    console.log(dist.slice(1).join(' '));
    break;
  }
}
