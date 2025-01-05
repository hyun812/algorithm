const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const k = +input[0];
const n = +input[1];
const final = input[2].slice(0, k).split('');
const ladder = input.slice(3).map((lines) => lines.slice(0, k - 1).split(''));
let alpha = Array.from({ length: k }, (_, i) => String.fromCharCode(65 + i));

for (let i = 0; i < n; i++) {
  if (ladder[i][0] === '?') break;
  for (let j = 0; j < k - 1; j++) {
    if (ladder[i][j] === '-') {
      [alpha[j], alpha[j + 1]] = [alpha[j + 1], alpha[j]];
    }
  }
}

for (let i = n - 1; i >= 0; i--) {
  if (ladder[i][0] === '?') break;
  for (let j = 0; j < k - 1; j++) {
    if (ladder[i][j] === '-') {
      [final[j], final[j + 1]] = [final[j + 1], final[j]];
    }
  }
}

let result = '';
for (let i = 0; i < k - 1; i++) {
  if (alpha[i] === final[i]) result += '*';
  else if (alpha[i] === final[i + 1] && alpha[i + 1] === final[i]) {
    result += '-';
    [alpha[i], alpha[i + 1]] = [alpha[i + 1], alpha[i]];
  } else {
    result = 'x'.repeat(k - 1);
    break;
  }
}

console.log(result);