const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const T = +input[0];
let num = 1;
for (tc = 0; tc < T; tc++) {
  const N = +input[num];
  const arr = input[num + 1].split(' ').map(Number);

  const min = Math.min(...arr);
  const max = Math.max(...arr);

  console.log(min, max);
  num += 2;
}
