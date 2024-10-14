const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const answer = [];
const n = +input[0];

const parents = [];
const count = [];

make();

for (let i = 1; i <= n; i++) {
  const row = input[i].split(' ');
  const type = row[0];

  if (type === 'I') {
    union(+row[1], +row[2]);
  } else if (type === 'Q') {
    const parent = find(+row[1]);
    answer.push(count[parent]);
  }
}

console.log(answer.join('\n'));

function make() {
  for (let i = 0; i <= 1000000; i++) {
    parents[i] = i;
    count[i] = 1;
  }
}

function union(a, b) {
  let aRoot = find(a);
  let bRoot = find(b);

  if (aRoot === bRoot) return false;

  if (aRoot > bRoot) {
    parents[aRoot] = bRoot;
    count[bRoot] += count[aRoot];
  } else {
    parents[bRoot] = aRoot;
    count[aRoot] += count[bRoot];
  }
  return true;
}

function find(a) {
  if (a === parents[a]) return a;

  const b = find(parents[a]);
  parents[a] = b;
  return b;
}