const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const K = +input[0];
const [W, H] = input[1].split(' ').map(Number);
const map = input.slice(2).map((lines) => lines.split(' ').map(Number));

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const horse_dy = [-2, -2, -1, -1, 1, 1, 2, 2];
const horse_dx = [-1, 1, -2, 2, -2, 2, -1, 1];

const outOfIndex = (y, x) => {
  if (y < 0 || x < 0 || y >= H || x >= W) {
    return false;
  }
  return true;
};

const bfs = () => {
  const visited = Array.from({ length: H }, () => Array.from({ length: W }, () => Array(K).fill(0)));
  const queue = [[0, 0, 0, 0]];

  visited[0][0][0] = 1;

  while (queue.length) {
    const [y, x, time, horse_count] = queue.shift();

    if (y === H - 1 && x === W - 1) {
      return time;
    }

    if (horse_count < K) {
      for (let i = 0; i < 8; i++) {
        const ny = y + horse_dy[i];
        const nx = x + horse_dx[i];

        if (!outOfIndex(ny, nx)) continue;
        if (map[ny][nx] === 1) continue;
        if (visited[ny][nx][horse_count + 1]) continue;

        visited[ny][nx][horse_count + 1] = 1;
        queue.push([ny, nx, time + 1, horse_count + 1]);
      }
    }

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (!outOfIndex(ny, nx)) continue;
      if (map[ny][nx] === 1) continue;
      if (visited[ny][nx][horse_count]) continue;

      visited[ny][nx][horse_count] = 1;
      queue.push([ny, nx, time + 1, horse_count]);
    }
  }

  return -1;
};

console.log(bfs());