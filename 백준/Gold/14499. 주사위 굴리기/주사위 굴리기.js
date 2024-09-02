const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

let [N, M, y, x, K] = input.shift().split(' ').map(Number);

const map = [];
for (let i = 0; i < N; i++) {
  map.push(input[i].split(' ').map(Number));
}

const orders = input[input.length - 1].split(' ').map(Number);

const dy = [0, 0, 0, -1, 1];
const dx = [0, 1, -1, 0, 0];
let dice = [0, 0, 0, 0, 0, 0]; // 1 2 3 4 5 6

const move = (order) => {
  switch (order) {
    case 1: // 동
      dice = [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]];
      break;
    case 2: // 서
      dice = [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]];
      break;
    case 3: // 북
      dice = [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]];
      break;
    case 4: // 남
      dice = [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]];
      break;
  }
};

const answer = [];

for (const order of orders) {
  const ny = y + dy[order];
  const nx = x + dx[order];

  if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

  move(order);

  if (map[ny][nx] === 0) {
    map[ny][nx] = dice[0];
  } else {
    dice[0] = map[ny][nx];
    map[ny][nx] = 0;
  }

  answer.push(dice[5]);

  y = ny;
  x = nx;
}

console.log(answer.join('\n'));