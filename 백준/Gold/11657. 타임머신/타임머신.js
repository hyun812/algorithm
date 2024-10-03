const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n").map(str => str.split(' ').map(Number));
const [N, M] = input.shift();
let cost = new Array(N + 1).fill(Infinity);
cost[1] = 0;

let answer = [];

for (let i = 0; i < N - 1; i++) {
  let change = false
  input.forEach(v => {
    const [A, B, C] = v;
    if (A !== Infinity && cost[A] + C < cost[B]) {
      cost[B] = cost[A] + C;
      change = true;
    }
  })
  if (!change) break;
}

answer = cost.slice(2, cost.length).map(v => {
  if (v === Infinity) return -1;
  return v;
}).join('\n');


let check = false;
for (let i = 0; i < M; i++) {
  const [A, B, C] = input[i];
  if (A !== Infinity && cost[A] + C < cost[B]) {
    cost[B] = cost[A] + C;
    check = true;
  }
  if (check) answer = -1;
}

console.log(answer)