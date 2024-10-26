const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const answer = [];
const arr = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0];

const solution = (num, index) => {
  if (!answer.includes(num)) answer.push(num);

  if (index >= 10) return;

  solution(num * 10 + arr[index], index + 1);
  solution(num, index + 1);
};

solution(0, 0);

answer.sort((a, b) => a - b);

console.log(answer[N - 1] ?? -1);