const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const K = +input[1];
const sensor = input[2].split(' ').map(Number);

sensor.sort((a, b) => a - b);

const diff = [];
for (let i = 0; i < N - 1; i++) {
  diff.push(sensor[i + 1] - sensor[i]);
}
diff.sort((a, b) => b - a);

let answer = 0;
for (let i = K - 1; i < N - 1; i++) {
  answer += diff[i];
}

console.log(answer);
