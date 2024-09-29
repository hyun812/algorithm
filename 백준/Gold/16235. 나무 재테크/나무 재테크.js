const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

/**
 * N: 크기
 * M: 심을 나무의 수
 * K: 몇년이 지났는지
 */
const [N, M, K] = input[0].split(' ').map(Number);

const addNutrient = Array.from({ length: N }, () => []);
for (let i = 0; i < N; i++) {
  addNutrient[i].push(...input[i + 1].split(' ').map(Number));
}

let trees = [];
for (let i = 1; i <= M; i++) {
  const [x, y, age] = input[N + i].split(' ').map(Number);
  trees.push({ x: x - 1, y: y - 1, age, death: false });
}
trees.sort((a, b) => b.age - a.age);

const map = Array.from({ length: N }, () => Array(N).fill(5));

function spring() {
  for (let i = trees.length - 1; i >= 0; i--) {
    const { x, y, age } = trees[i];
    if (map[x][y] < age) {
      trees[i].death = true;
    } else {
      map[x][y] -= age;
      trees[i].age += 1;
    }
  }
}

function summer() {
  trees = trees.filter(({ x, y, age, death }) => {
    if (death) {
      map[x][y] += Math.floor(age / 2);
      return false;
    } else {
      return true;
    }
  });
}

const dx = [-1, 1, 0, 0, 1, 1, -1, -1];
const dy = [0, 0, -1, 1, 1, -1, 1, -1];
function autumn() {
  for (let i = 0; i < trees.length; i++) {
    const { x, y, age } = trees[i];

    if (age % 5 !== 0) continue;

    for (let i = 0; i < 8; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

      trees.push({ x: nx, y: ny, age: 1, death: false });
    }
  }
}

function winter() {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      map[i][j] += addNutrient[i][j];
    }
  }
}

for (let i = 0; i < K; i++) {
  spring();
  summer();
  autumn();
  winter();
}

console.log(trees.length);