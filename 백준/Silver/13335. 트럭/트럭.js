const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [n, w, L] = input[0].split(' ').map(Number);
const truck = input[1].split(' ').map(Number);

let time = 0;
let index = 0;

let bridge = [];

while (true) {
  if (!bridge.length && index === n) break;

  time++;

  bridge = bridge.filter((v) => v.position !== w).map((v) => ({ truck: v.truck, position: v.position + 1 }));

  // 트럭이 다리위에 올라갈 수 있다면
  const weight = bridge.map((v) => v.truck).reduce((acc, cur) => acc + cur, 0);
  if (weight + truck[index] <= L && bridge.length <= w) {
    bridge.push({ truck: truck[index], position: 1 });
    index++;
  }
}

console.log(time);
