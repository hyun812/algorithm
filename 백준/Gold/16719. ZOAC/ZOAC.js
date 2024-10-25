const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const alpha = input[0].split('');
const words = new Array(alpha.length).fill('');

const answer = [];

const solution = (array, start) => {
  if (!array.length) return;

  const sort_alpha = array.slice().sort();

  const minAlpha = sort_alpha[0];
  const minIndex = array.indexOf(minAlpha);

  words[start + minIndex] = minAlpha;
  answer.push(words.join(''));

  solution(array.slice(minIndex + 1), start + minIndex + 1);
  solution(array.slice(0, minIndex), start);
};

solution(alpha, 0);

console.log(answer.join('\n'));
