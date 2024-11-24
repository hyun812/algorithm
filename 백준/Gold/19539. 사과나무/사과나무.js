const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const trees = input[1].split(' ').map(Number);

const sum = trees.reduce((acc, cur) => acc + cur, 0);
const two = trees.reduce((acc, cur) => acc + Math.floor(cur / 2), 0);

if (sum % 3 === 0 && two >= sum / 3) {
  console.log('YES');
} else {
  console.log('NO');
}
