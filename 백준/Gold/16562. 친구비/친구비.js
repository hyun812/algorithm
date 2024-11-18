const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M, k] = input[0].split(' ').map(Number);
const money = [0, ...input[1].split(' ').map(Number)];

const parents = Array(N + 1)
  .fill(0)
  .map((_, idx) => idx);

const find = (a) => {
  if (parents[a] === a) return a;

  const b = find(parents[a]);
  parents[a] = b;
  return b;
};

const union = (a, b) => {
  let aRoot = find(a);
  let bRoot = find(b);

  if (aRoot === bRoot) return false;
  if (money[aRoot] > money[bRoot]) {
    parents[aRoot] = bRoot;
  } else {
    parents[bRoot] = aRoot;
  }

  return true;
};

for (let i = 0; i < M; i++) {
  const [from, to] = input[i + 2].split(' ').map(Number);

  union(from, to);
}

const result = [...new Set(parents.slice(1).map((v) => find(v)))].reduce((acc, cur) => acc + money[cur], 0);

k >= result ? console.log(result) : console.log('Oh no');