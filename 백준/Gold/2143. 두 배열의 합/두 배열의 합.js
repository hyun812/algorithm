const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

let answer = 0;
const [T, n, m] = [+input[0], +input[1], +input[3]];
const aArr = input[2].split(' ').map(Number);
const bArr = input[4].split(' ').map(Number);

const aMap = new Map();
for (let i = 0; i < n; i++) {
  let sum = 0;
  for (let j = i; j < n; j++) {
    sum += aArr[j];
    aMap.set(sum, (aMap.get(sum) ?? 0) + 1);
  }
}

for (let i = 0; i < m; i++) {
  let sum = 0;
  for (let j = i; j < m; j++) {
    sum += bArr[j];
    answer += aMap.get(T - sum) ?? 0;
  }
}

console.log(answer);
