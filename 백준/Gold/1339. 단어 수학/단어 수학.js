const fs = require('fs');
// ./dev/stdin
const [N, ...input] = fs.readFileSync('./dev/stdin').toString().trim().split(/\s+/);

const map = new Map();
let answer = 0;

input.forEach((word) => {
  for (let i = 0; i < word.length; i++) {
    const cnt = Math.pow(10, word.length - (i + 1));
    map.set(word[i], (map.get(word[i]) || 0) + cnt);
  }
});

const sort = new Map([...map.entries()].sort((a, b) => b[1] - a[1]));

let cur = 9;
for (let [_, v] of sort) {
  answer += v * cur;
  cur--;
}
console.log(answer);