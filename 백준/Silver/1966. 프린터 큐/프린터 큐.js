const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const T = +input[0];

const answer = [];
let num = 1;
for (let tc = 0; tc < T; tc++) {
  const [N, M] = input[num].split(' ').map(Number);
  const docs = input[num + 1].split(' ').map(Number);

  const count = checkPrint(docs, M);
  answer.push(count);

  num += 2;
}

console.log(answer.join('\n'));

function checkPrint(docs, M) {
  let count = 1;
  while (true) {
    const target = docs.shift();
    const max = Math.max(...docs);

    if (target >= max) {
      if (M === 0) return count;
      M -= 1;
      count += 1;
    } else {
      docs.push(target);
      M = M === 0 ? docs.length - 1 : M - 1;
    }
  }
}
