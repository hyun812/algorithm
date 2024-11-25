const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(0, 'utf-8').toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const parents = Array(n + 1)
  .fill(0)
  .map((_, i) => i);

const find = (a) => {
  if (parents[a] === a) return a;

  const b = find(parents[a]);
  parents[a] = b;
  return b;
};

const union = (a, b) => {
  const aRoot = find(a);
  const bRoot = find(b);

  if (aRoot === bRoot) return true;

  parents[bRoot] = aRoot;

  return false;
};

for (let i = 1; i <= m; i++) {
  const [type, a, b] = input[i].split(' ').map(Number);

  if (!type) {
    union(a, b);
  } else {
    if (find(a) === find(b)) {
      console.log('YES');
    } else {
      console.log('NO');
    }
  }
}