const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = [+input[0], +input[1]];
const parents = Array(N + 1)
  .fill(0)
  .map((_, i) => i);

const find = (a) => {
  if (parents[a] === a) return a;

  return (parents[a] = find(parents[a]));
};

const union = (a, b) => {
  const aRoot = find(a);
  const bRoot = find(b);

  if (aRoot === bRoot) return false;

  parents[bRoot] = aRoot;
  return true;
};

for (let i = 2; i < N + 2; i++) {
  const graph = input[i].split(' ').map(Number);

  graph.forEach((node, index) => {
    if (node) union(i - 1, index + 1);
  });
}

const paths = input[N + 2].split(' ').map(Number);

let answer = 'YES';
let prev = find(paths[0]);
for (let i = 1; i < paths.length; i++) {
  if (prev === find(paths[i])) continue;

  answer = 'NO';
}

console.log(answer);