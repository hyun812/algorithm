const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const [count, ...truth] = input[1].split(' ').map(Number);

const parents = Array(N + 1)
  .fill(0)
  .map((_, i) => i);

let knowTruth = Array(N + 1).fill(0);
for (let i = 0; i < count; i++) {
  knowTruth[truth[i]] = 1;
}
const party = Array.from({ length: M }, () => []);
for (let i = 0; i < M; i++) {
  [num, ...party[i]] = input[i + 2].split(' ').map(Number);

  const first = party[i][0];
  for (let j = 1; j < num; j++) {
    union(first, party[i][j]);
  }
}

const visited = Array(N + 1).fill(0);
for (let i = 1; i <= N; i++) {
  if (!knowTruth[i]) continue;
  if (visited[i]) continue;

  const root = find(i);
  for (let j = 1; j <= N; j++) {
    if (find(j) === root) {
      knowTruth[j] = 1;
      visited[j] = 1;
    }
  }
}

let answer = 0;
for (let i = 0; i < M; i++) {
  const target = party[i];

  let flag = true;
  for (let j = 0; j < target.length; j++) {
    if (knowTruth[target[j]]) {
      flag = false;
      break;
    }
  }
  if (flag) answer++;
}

console.log(answer);

function union(a, b) {
  let aRoot = find(a);
  let bRoot = find(b);

  if (aRoot === bRoot) return false;

  parents[bRoot] = aRoot;
  return true;
}

function find(a) {
  if (parents[a] === a) return a;

  const b = find(parents[a]);
  parents[a] = b;

  return b;
}