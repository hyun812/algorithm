const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const map = [];
for (let i = 0; i < N; i++) {
  map[i] = input[i + 1].split(' ').map(Number);
}

const orders = [];
for (let i = N + 1; i < N + M + 1; i++) {
  const [d, s] = input[i].split(' ').map(Number);
  orders.push({ d, s });
}

const dy = [0, 0, -1, -1, -1, 0, 1, 1, 1];
const dx = [0, -1, -1, 0, 1, 1, 1, 0, -1];
const diaY = [-1, 1, 1, -1];
const diaX = [-1, 1, -1, 1];

let cloud = [
  [N - 1, 0],
  [N - 2, 0],
  [N - 1, 1],
  [N - 2, 1],
];

const moveCloud = (d, s) => {
  cloud = cloud.map(([y, x]) => {
    let ny = (y + dy[d] * s) % N;
    let nx = (x + dx[d] * s) % N;

    if (ny < 0) ny = N - Math.abs(ny);
    if (nx < 0) nx = N - Math.abs(nx);
    return [ny, nx];
  });
};

const raining = () => {
  if (!cloud) return;

  // 구름이 있었던 칸을 제외하기 위한 방문 체크
  const visited = Array.from({ length: N }, () => Array(N).fill(0));
  // 비
  cloud.forEach(([y, x]) => {
    map[y][x]++;
    visited[y][x] = 1;
  });

  // 대각선 확인
  cloud.forEach(([y, x]) => {
    let count = 0;
    for (let i = 0; i < 4; i++) {
      const ny = y + diaY[i];
      const nx = x + diaX[i];
      if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if (map[ny][nx] > 0) count++;
    }
    map[y][x] += count;
  });

  // 구름 생성
  const newCloud = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (map[i][j] < 2) continue;
      if (visited[i][j]) continue;

      newCloud.push([i, j]);
      map[i][j] = map[i][j] >= 2 ? map[i][j] - 2 : 0;
    }
  }
  cloud = newCloud;
};

orders.forEach((order) => {
  moveCloud(order.d, order.s);
  raining();
});

let answer = 0;
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    answer += map[i][j];
  }
}
console.log(answer);
