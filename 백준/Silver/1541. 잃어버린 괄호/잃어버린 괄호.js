const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [input] = fs.readFileSync(filePath).toString().trim().split('\n');

const answer = [];
input.split('-').forEach((item) => {
  if (item.includes('+')) {
    const sum = item
      .split('+')
      .map(Number)
      .reduce((acc, cur) => acc + cur, 0);
    answer.push(sum);
  } else {
    answer.push(+item);
  }
});

console.log(answer.reduce((acc, cur) => acc - cur));
