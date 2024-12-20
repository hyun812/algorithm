const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [V, E] = input[0].split(' ').map(Number);
const edges = input.slice(1).map((lines) => lines.split(' ').map(Number));
const degree = Array(V + 1).fill(0);
const parents = Array(V + 1)
  .fill(0)
  .map((_, i) => i);

const find = (a) => {
  if (a === parents[a]) return a;

  return (parents[a] = find(parents[a]));
};

const union = (a, b) => {
  const rootA = find(a);
  const rootB = find(b);

  if (rootA === rootB) return;

  parents[rootB] = rootA;
};

for (const [a, b] of edges) {
  union(a, b);

  degree[a]++;
  degree[b]++;
}

const rootSet = new Set();
for (let i = 1; i <= V; i++) {
  if (degree[i] > 0) {
    rootSet.add(find(i));
  }
}

let answer = '';
if (rootSet.size > 1) {
  answer = 'NO';
} else {
  const oddDegreeCount = degree.filter((d) => d % 2 !== 0).length;
  answer = oddDegreeCount === 0 || oddDegreeCount === 2 ? 'YES' : 'NO';
}

console.log(answer);
