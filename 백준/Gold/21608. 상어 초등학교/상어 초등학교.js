const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const students = input.slice(1).map((lines) => {
  const [num, ...likes] = lines.split(' ').map(Number);
  return { num, likes };
});

const map = Array.from({ length: N }, () => Array(N).fill(0));

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

for (let i = 0; i < N ** 2; i++) {
  if (i === 0) map[1][1] = students[0].num;
  else {
    selectSeat(students[i].num);
  }
}

function selectSeat(num) {
  const info = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (map[i][j]) continue; // 이미 배치된 자리면 continue;

      info.push(getSeatInfo(i, j, num));
    }
  }

  info.sort((a, b) => {
    if (a.likes !== b.likes) {
      return b.likes - a.likes;
    } else if (a.empty !== b.empty) {
      return b.empty - a.empty;
    } else if (a.y !== b.y) {
      return a.y - b.y;
    } else if (a.x !== b.x) {
      return a.x - b.x;
    }
  });

  map[info[0].y][info[0].x] = num;
}

function getSeatInfo(y, x, num) {
  let empty = 0; // 비어 있는 칸의 수
  let likes = 0; // 좋아하는 학생의 수

  const studentLikes = students.find((student) => student.num === num).likes;

  for (let i = 0; i < 4; i++) {
    const ny = y + dy[i];
    const nx = x + dx[i];

    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
    if (!map[ny][nx]) empty++;
    else if (studentLikes.includes(map[ny][nx])) likes++;
  }

  return { y, x, empty, likes };
}

calcResult();

function calcResult() {
  let result = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      const { likes } = getSeatInfo(i, j, map[i][j]);
      result += Math.floor(10 ** (likes - 1));
    }
  }
  console.log(result);
}