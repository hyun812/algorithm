const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [n, h, ...arr] = fs.readFileSync(filePath).toString().trim().split(/\s+/).map(Number);

const down = Array(h + 1).fill(0);
const up = Array(h + 1).fill(0);

arr.forEach((v, idx) => {
  idx % 2 === 0 ? down[v]++ : up[h - v + 1]++;
});

for (let i = 1; i <= h; i++) {
  down[h - i] += down[h - i + 1];
  up[i] += up[i - 1];
}

let [min, cnt] = [Infinity, 0];

for (let i = 1; i <= h; i++) {
  const sum = down[i] + up[i];

  if (sum < min) {
    min = sum;
    cnt = 1;
  } else if (sum === min) {
    cnt++;
  }
}
// 파괴해야하는 장애물의 최소값과 구간의 수
console.log(min, cnt);