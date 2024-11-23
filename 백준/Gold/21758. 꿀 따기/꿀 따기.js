const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const honey = input[1].split(' ').map(Number);
const prefix = Array(n + 1).fill(0);

honey.unshift(0);

for (let i = 1; i <= n; i++) {
  prefix[i] = honey[i] + prefix[i - 1];
}
// 벌 통 벌 순서로 있는 경우 => 벌을 양끝에 고정 시키고 꿀통을 옮김
let answer = 0;
for (let i = 2; i < n; i++) {
  const bee1 = prefix[i] - honey[1];
  const bee2 = prefix[n] - prefix[i - 1] - honey[n];
  answer = Math.max(answer, bee1 + bee2);
}

// 벌 벌 통 순서로 있는 경우 => 벌 한마리는 왼쪽 끝에 고정 + 꿀통은 오른쪽 끝에 고정
for (let i = 2; i < n; i++) {
  const bee1 = prefix[n] - honey[1] - honey[i];
  const bee2 = prefix[n] - prefix[i];
  answer = Math.max(answer, bee1 + bee2);
}

// 통 벌 벌 순서로 있는 경우 => 꿀통은 왼쪽 끝에 고정 + 벌 한마리는 오른쪽 끝에 고정
for (let i = 2; i < n; i++) {
  const bee1 = prefix[n] - honey[n] - honey[i];
  const bee2 = prefix[i - 1];
  answer = Math.max(answer, bee1 + bee2);
}

console.log(answer);