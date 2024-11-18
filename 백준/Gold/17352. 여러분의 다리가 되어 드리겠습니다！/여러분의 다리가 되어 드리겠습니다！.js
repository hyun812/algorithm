const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];

const parents = Array(N + 1)
  .fill(0)
  .map((_, idx) => idx);

const find = (a) => {
  if (a === parents[a]) return a;

  const b = find(parents[a]);
  parents[a] = b;
  return b;
};

const union = (a, b) => {
  const rootA = find(a);
  const rootB = find(b);

  if (rootA === rootB) return false;

  parents[rootB] = rootA;
  return true;
};

for (let i = 0; i < N - 2; i++) {
  const [from, to] = input[i + 1].split(' ').map(Number);

  union(from, to);
}

console.log([...new Set(parents.slice(1).map((v) => find(v)))].join(' '));