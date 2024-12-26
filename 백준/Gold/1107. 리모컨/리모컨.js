const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const M = +input[1];
const arr = M ? input[2].split(' ').map(Number) : [];
const breakDown = new Set(arr);

let answer = Math.abs(N - 100);

for (let i = 0; i <= 999999; i++) {
  const target = String(i);
  const length = target.length;

  let isBreak = false;
  for (let j = 0; j < length; j++) {
    if (breakDown.has(+target[j])) {
      isBreak = true;
      break;
    }
  }

  if (!isBreak) {
    const press = length + Math.abs(N - i);
    answer = Math.min(answer, press);
  }
}

console.log(answer);