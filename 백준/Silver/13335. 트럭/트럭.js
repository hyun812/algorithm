const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, w, L] = input[0].split(' ').map(Number);
const truck = input[1].split(' ').map(Number);

const bridge = new Array(w).fill(0);
let time = 0;

while (truck.length) {
  const target = truck[0];

  const weight = bridge.reduce((acc, cur) => acc + cur, 0);
  if (weight + target - bridge[0] <= L) {
    bridge.shift();
    bridge.push(truck.shift());
  } else {
    bridge.shift();
    bridge.push(0);
  }
  time++;
}

while (bridge.length) {
  bridge.shift();
  time++;
}

console.log(time);