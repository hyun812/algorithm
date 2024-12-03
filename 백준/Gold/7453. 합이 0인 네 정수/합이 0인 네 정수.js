const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const A = [];
const B = [];
const C = [];
const D = [];

for (let i = 0; i < n; i++) {
  const [a, b, c, d] = input[i + 1].split(' ').map(Number);
  A.push(a);
  B.push(b);
  C.push(c);
  D.push(d);
}

const map = new Map();
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    const sum = A[i] + B[j];
    map.set(sum, (map.get(sum) || 0) + 1);
  }
}

let answer = 0;

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    const sum = C[i] + D[j];
    if (map.has(-sum)) {
      answer += map.get(-sum);
    }
  }
}

console.log(answer);