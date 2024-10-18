const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const S = input[0].split('');
const T = input[1].split('');

let answer = 0;

const dfs = (words) => {
  if (words.join('') === S.join('')) {
    answer = 1;
    return;
  }

  if (words.length < S.length) {
    return;
  }

  if (words[words.length - 1] === 'A') {
    const newArr = [...words];
    newArr.pop();
    dfs(newArr);
  }

  if (words[0] === 'B') {
    const newArr = [...words];
    newArr.shift();
    dfs(newArr.reverse());
  }
};

dfs(T);

console.log(answer);