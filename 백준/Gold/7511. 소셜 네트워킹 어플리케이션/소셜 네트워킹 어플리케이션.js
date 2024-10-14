const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const T = +input[0];
let num = 1;
let parents = [];
const answer = [];

for (let tc = 1; tc <= T; tc++) {
  answer.push(`Scenario ${tc}:`);

  parents = [];
  const n = +input[num];
  const k = +input[num + 1];

  make(n);

  for (let i = 0; i < k; i++) {
    const [a, b] = input[num + 2 + i].split(' ').map(Number);
    union(a, b);
  }

  const m = +input[num + k + 2];
  for (let i = 0; i < m; i++) {
    const [a, b] = input[num + k + 3 + i].split(' ').map(Number);
    find(a) === find(b) ? answer.push(1) : answer.push(0);
  }

  answer.push('');
  num += k + m + 3;
}

console.log(answer.join('\n'));

function make(n) {
  for (let i = 0; i < n; i++) {
    parents[i] = i;
  }
}

function find(a) {
  if (a === parents[a]) return a;

  const b = find(parents[a]);
  parents[a] = b;
  return b;
}

function union(a, b) {
  let aRoot = find(a);
  let bRoot = find(b);

  if (aRoot === bRoot) return;

  parents[bRoot] = aRoot;
  return;
}