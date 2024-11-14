const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map((lines) => lines.split(' ').map(Number));

const dy = [1, 0, -1, 0]; // 하, 우, 상, 좌
const dx = [0, 1, 0, -1];

let roomCount = 0; // 방의 개수
let maxSize = 0; // 가장 넓은 방의 크기
let destroyMaxSize = 0; // 하나의 벽을 제거했을 때 가장 넓은 방으 ㅣ크기

// 8 4 2 1 (하, 우, 상, 좌)
// 11 => 하 상 좌

const room = Array.from({ length: M }, () => Array(N).fill(0));
const count = [];
const bfs = (startY, startX, roomNumber) => {
  const queue = [[startY, startX, 1]];
  room[startY][startX] = roomNumber;
  count.push(0);

  while (queue.length) {
    const [y, x, size] = queue.shift();

    count[count.length - 1]++;
    const dir = map[y][x].toString(2).padStart(4, '0');

    for (let i = 0; i < 4; i++) {
      if (dir[i] === '1') continue;

      const ny = y + dy[i];
      const nx = x + dx[i];

      if (room[ny][nx]) continue;

      queue.push([ny, nx, size + 1]);
      room[ny][nx] = roomNumber;
    }
  }
};

for (let i = 0; i < M; i++) {
  for (let j = 0; j < N; j++) {
    if (room[i][j]) continue;

    roomCount++;
    bfs(i, j, roomCount);
  }
}

for (let i = 0; i < M; i++) {
  for (let j = 0; j < N; j++) {
    for (let k = 0; k < 4; k++) {
      const ny = i + dy[k];
      const nx = j + dx[k];

      if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
      if (room[i][j] === room[ny][nx]) continue;

      destroyMaxSize = Math.max(destroyMaxSize, count[room[i][j] - 1] + count[room[ny][nx] - 1]);
    }
  }
}

console.log(roomCount);
console.log(Math.max(...count));
console.log(destroyMaxSize);
