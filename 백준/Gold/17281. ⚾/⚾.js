const fs = require("fs");
// const [N, ...input] = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const N = Number(input.shift());
const arr = input.map((v) => v.split(" ").map(Number));
const nums = Array(9).fill(0);
const visited = Array(9).fill(false);
let answer = 0;

const play = () => {
  let inning = 0;
  let score = 0;
  let outCount = 0;
  let last = 0;

  let base1 = 0;
  let base2 = 0;
  let base3 = 0;

  while (inning < N) {
    if (outCount === 3) {
      inning++;
      outCount = 0;
      base1 = base2 = base3 = base4 = 0;
      continue;
    }

    const batter = arr[inning][nums[last]];

    switch (batter) {
      case 0:
        outCount++;
        break;
      case 1:
        score += base3;
        base3 = base2;
        base2 = base1;
        base1 = 1;
        break;
      case 2:
        score += base3 + base2;
        base3 = base1;
        base2 = 1;
        base1 = 0;
        break;
      case 3:
        score += base3 + base2 + base1;
        base1 = base2 = 0;
        base3 = 1;
        break;
      case 4:
        score += base3 + base2 + base1 + 1;
        base1 = base2 = base3 = 0;
        break;
    }

    last = (last + 1) % 9;
  }

  answer = Math.max(answer, score);
};

const getPermutation = (count) => {
  if (count === 9) {
    play();
    return;
  }

  if (count === 3) {
    getPermutation(count + 1);
    return;
  }

  for (let i = 1; i < 9; i++) {
    if (visited[i]) continue;
    nums[count] = i;
    visited[i] = true;
    getPermutation(count + 1);
    visited[i] = false;
  }
};

nums[3] = 0;
getPermutation(0);

console.log(answer);
