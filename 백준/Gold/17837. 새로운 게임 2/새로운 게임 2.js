const fs = require('fs');
const input = fs
  .readFileSync('./dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map((v) => v.split(' ').map(Number));

const dx = [0, 0, 0, -1, 1];
const dy = [0, 1, -1, 0, 0];

const reverse = [0, 2, 1, 4, 3];

const [N, M] = input.shift();
let board = input.splice(0, N).map((r) =>
  r.map((v) => {
    return { color: v, stack: [] };
  })
);
let mal = input.map((v) => [v[0] - 1, v[1] - 1, v[2]]);
mal.forEach((v, i) => {
  const [x, y, _] = v;
  board[x][y].stack.push(i);
});

let cnt = 1;
let end = false;

while (cnt <= 1000) {
  for (let i = 0; i < mal.length; i++) {
    const [x, y, k] = mal[i];
    const nx = x + dx[k];
    const ny = y + dy[k];

    if (
      nx < 0 ||
      ny < 0 ||
      nx >= N ||
      ny >= N ||
      (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny].color == 2)
    ) {
      mal[i] = [x, y, reverse[k]];
      const bx = x + dx[reverse[k]];
      const by = y + dy[reverse[k]];
      if (bx >= 0 && by >= 0 && bx < N && by < N && board[bx][by].color != 2) {
        i--;
      }
    } else if (board[nx][ny].color == 0) {
      //흰색
      const loc = board[x][y].stack.indexOf(i);
      const malSet = board[x][y].stack.splice(loc);
      board[nx][ny].stack = [...board[nx][ny].stack, ...malSet];
      malSet.forEach((v) => {
        mal[v][0] = nx;
        mal[v][1] = ny;
      });

      if (board[nx][ny].stack.length >= 4) {
        end = true;
      }
    } else if (board[nx][ny].color == 1) {
      // 빨간색
      const loc = board[x][y].stack.indexOf(i);
      const malSet = board[x][y].stack.splice(loc);
      const malSetReverse = malSet.reverse();
      board[nx][ny].stack = [...board[nx][ny].stack, ...malSetReverse];
      malSetReverse.forEach((u) => {
        mal[u][0] = nx;
        mal[u][1] = ny;
      });

      if (board[nx][ny].stack.length >= 4) {
        end = true;
      }
    }
    if (end) break;
  }
  if (end) break;
  cnt++;
}

if (cnt > 1000) {
  console.log(-1);
} else {
  console.log(cnt);
}