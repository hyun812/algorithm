const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const city = [];
for (let i = 0; i < N; i++) {
  city.push(input[i + 1].split(' ').map(Number));
}

city.sort((a, b) => a[0] - b[0]);
const peopleCount = city.reduce((acc, cur) => acc + cur[1], 0);

let sum = 0;
let answer = -1;
for (let i = 0; i < N; i++) {
  sum += city[i][1];
  if (peopleCount / 2 <= sum) {
    answer = city[i][0];
    break;
  }
}
console.log(answer);