const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [H, W] = input[0].split(' ').map(Number);
const blocks = input[1].split(' ').map(Number);

let rain = 0;

for (let i = 0; i < W; i++) {
  const left = Math.max(...blocks.slice(0, i + 1));
  const right = Math.max(...blocks.slice(i));

  rain += Math.min(left, right) - blocks[i];
}

console.log(rain);