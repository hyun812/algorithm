const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [t, ...input] = fs.readFileSync(filePath).toString().trim().split('\n');

const answer = [];

const check = (word, left, right) => {
  while (left < right) {
    if (word[left] === word[right]) {
      left++;
      right--;
    } else return false;
  }
  return true;
};

const doit = (word) => {
  let left = 0;
  let right = word.length - 1;

  while (left < right) {
    if (word[left] === word[right]) {
      left++;
      right--;
    } else {
      if (check(word, left + 1, right) || check(word, left, right - 1)) return 1;
      return 2;
    }
  }
  return 0;
};

for (const word of input) {
  answer.push(doit(word));
}
console.log(answer.join('\n'));