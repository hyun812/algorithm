const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const dx = [1, 0, -1, 0];
const dy = [0, -1, 0, 1];
const map = Array.from({ length: 101 }, () => Array(101).fill(0));

const N = +input[0];
for (let i = 0; i < N; i++) {
  const [x, y, d, g] = input[i + 1].split(' ').map(Number);

  const directions = getDirections(d, g);
  draw(x, y, directions);
}

console.log(checkSquare());

function getDirections(d, g) {
  const directions = [d];
  while (g-- > 0) {
    for (let i = directions.length - 1; i >= 0; i--) {
      let d = (directions[i] + 1) % 4;
      directions.push(d);
    }
  }

  return directions;
}

function draw(x, y, directions) {
  map[x][y] = 1;

  let nx = x;
  let ny = y;
  for (let i = 0; i < directions.length; i++) {
    let dIdx = directions[i];

    nx += dx[dIdx];
    ny += dy[dIdx];

    map[nx][ny] = 1;
  }
}

function checkSquare() {
  let result = 0;

  for (let i = 0; i < 100; i++) {
    for (let j = 0; j < 100; j++) {
      if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) result++;
    }
  }

  return result;
}