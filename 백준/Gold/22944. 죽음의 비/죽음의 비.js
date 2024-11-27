const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, H, D] = input[0].split(' ').map(Number);
const board = input.slice(1).map((lines) => lines.slice(0, N).split(''));

let [sy, sx] = [0, 0];
let [uy, ux] = [0, 0];
let [ey, ex] = [0, 0];

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (board[i][j] === '.') continue;

    if (board[i][j] === 'S') [sy, sx] = [i, j];
    else if (board[i][j] === 'U') [uy, ux] = [i, j];
    else if (board[i][j] === 'E') [ey, ex] = [i, j];
  }
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const bfs = () => {
  const queue = [[sy, sx, 0, H, 0]];
  const visited = Array.from({ length: N }, () => Array(N).fill(0));

  visited[sy][sx] = H;

  while (queue.length) {
    const [y, x, len, hp, umbrella] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];
      let _hp = hp;
      let _umbrella = umbrella;

      if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if (ny === ey && nx === ex) return len + 1;
      if (board[ny][nx] === 'U') _umbrella = D;

      _umbrella !== 0 ? _umbrella-- : _hp--;

      if (_hp === 0) continue;
      if (visited[ny][nx] >= _hp + _umbrella) continue;

      visited[ny][nx] = _hp + _umbrella;
      queue.push([ny, nx, len + 1, _hp, _umbrella]);
    }
  }

  return -1;
};

console.log(bfs());