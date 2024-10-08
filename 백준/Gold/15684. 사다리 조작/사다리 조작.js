const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M, H] = input[0].split(' ').map(Number);

const map = Array.from({ length: H + 1 }, () => Array(N + 1).fill(0));

for (let i = 1; i <= M; i++) {
  const [a, b] = input[i].split(' ').map(Number);

  map[a][b] = 1;
  map[a][b + 1] = 2;
}

let ans = -1;
let isFinish = false;
for (let i = 0; i <= 3; i++) {
  dfs(0, i);
  if (isFinish) {
    ans = i;
    break;
  }
}

console.log(ans);

function dfs(count, max) {
  if (isFinish) return;
  if (max === count) {
    if (check()) isFinish = true;
    return;
  }

  for (let i = 1; i <= H; i++) {
    for (let j = 1; j <= N; j++) {
      if (map[i][j] === 0 && map[i][j + 1] === 0) {
        map[i][j] = 1;
        map[i][j + 1] = 2;
        dfs(count + 1, max);
        map[i][j] = 0;
        map[i][j + 1] = 0;
      }
    }
  }
}

function check() {
  for (let i = 1; i <= N; i++) {
    let ny = 1;
    let nx = i;

    while (ny <= H) {
      if (map[ny][nx] === 1) nx++;
      else if (map[ny][nx] === 2) nx--;
      ny++;
    }

    if (nx !== i) return false;
  }

  return true;
}