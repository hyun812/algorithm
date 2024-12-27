/**
 * N이 10
 * 1. 부분집합 사용해서 1번 선거구와 2번 선거구로 나누는 경우의 수를 구한다.
 * 2. bfs를 사용해서 각 선거구가 연결되어 있는지 확인한다.
 * 3. 각 선거구의 인구수를 구해서 차이를 구한다.
 * 4. 차이가 가장 작은 값을 구한다.
 */

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const population = input[1].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
let answer = Infinity;

for (let i = 1; i <= N; i++) {
  const [cnt, ...arr] = input[i + 1].split(' ').map(Number);

  for (const from of arr) {
    graph[i].push(from);
  }
}

const bfs = (arr) => {
  const visited = Array(N + 1).fill(false);
  const queue = [];

  queue.push(arr[0]);
  visited[arr[0]] = 1;

  while (queue.length) {
    const cur = queue.shift();

    for (const next of graph[cur]) {
      if (visited[next]) continue;
      if (!arr.includes(next)) continue;

      queue.push(next);
      visited[next] = 1;
    }
  }

  return arr.every((v) => visited[v]);
};

const visited = Array(N + 1).fill(0);
const powerSet = (cnt) => {
  if (cnt === N + 1) {
    const a = [];
    const b = [];

    for (let i = 1; i <= N; i++) {
      visited[i] ? a.push(i) : b.push(i);
    }

    // 공집합이라면
    if (!a.length || !b.length) return;

    // 연결되어 있다면
    if (bfs(a) && bfs(b)) {
      let aSum = a.reduce((acc, cur) => acc + population[cur - 1], 0);
      let bSum = b.reduce((acc, cur) => acc + population[cur - 1], 0);

      answer = Math.min(answer, Math.abs(aSum - bSum));
    }

    return;
  }

  visited[cnt] = 1;
  powerSet(cnt + 1);
  visited[cnt] = 0;
  powerSet(cnt + 1);
};

powerSet(1);

console.log(answer === Infinity ? -1 : answer);