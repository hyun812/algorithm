const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const k = +input[0];
const binary = (k + 1).toString(2).split('');
binary.shift();

const result = binary.map((bit) => (bit === '1' ? '7' : '4')).join('');
console.log(result);