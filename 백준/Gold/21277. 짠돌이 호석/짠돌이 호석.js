const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const board = Array.from({ length: 151 }, () => Array(151).fill(0));
const puzzle1 = Array.from({ length: 51 }, () => Array(51).fill(0));
const puzzle2 = Array.from({ length: 51 }, () => Array(51).fill(0));

let answer = Infinity;

let [N1, M1] = input[0].split(' ').map(Number);
for (let i = 0; i < N1; i++) {
  const lines = input[i + 1].split('').map(Number);
  for (let j = 0; j < M1; j++) {
    puzzle1[i][j] = lines[j];
  }
}

let [N2, M2] = input[N1 + 1].split(' ').map(Number);
for (let i = 0; i < N2; i++) {
  const lines = input[N1 + i + 2].split('').map(Number);
  for (let j = 0; j < M2; j++) {
    puzzle2[i][j] = lines[j];
    board[i + 50][j + 50] = puzzle2[i][j];
  }
}

const rotate = () => {
  const tmp = Array.from({ length: 51 }, () => Array(51).fill(0));
  for (let i = M1 - 1; i >= 0; i--) {
    for (let j = 0; j < N1; j++) {
      tmp[M1 - 1 - i][j] = puzzle1[j][i];
    }
  }

  // 회전된 퍼즐로 업데이트
  for (let i = 0; i <= 50; i++) {
    for (let j = 0; j <= 50; j++) {
      puzzle1[i][j] = tmp[i][j];
    }
  }
  [N1, M1] = [M1, N1]; // n1과 m1 스왑
};

const solution = (y, x) => {
  for (let i = y; i < y + N1; i++) {
    for (let j = x; j < x + M1; j++) {
      if (board[i][j] === 1 && puzzle1[i - y][j - x] === 1) return;
    }
  }

  const minY = Math.min(y, 50);
  const maxY = Math.max(y + N1, 50 + N2) - 1;
  const minX = Math.min(x, 50);
  const maxX = Math.max(x + M1, 50 + M2) - 1;

  const area = (maxY - minY + 1) * (maxX - minX + 1);
  answer = Math.min(answer, area);
};

for (let k = 0; k < 4; k++) {
  rotate();
  for (let i = 0; i < 100; i++) {
    for (let j = 0; j < 100; j++) {
      solution(i, j);
    }
  }
}

console.log(answer);
