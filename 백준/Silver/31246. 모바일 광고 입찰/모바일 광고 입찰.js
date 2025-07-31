const fs = require("fs");
// const [N, ...input] = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const input = fs
  .readFileSync("./dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => item.split(" ").map(Number));

const [N, K] = input.shift();

let count = 0;
const answer = [];
input.forEach((item) => {
  const [A, B] = item;

  // A: 제시한 입찰가격
  // B: 입찰가를 제외한 다른 모든 입찰가 중 최고가격
  if (A >= B) {
    count++;
  } else {
    answer.push(B - A);
  }
});

if (count >= K) console.log(0);
else {
  answer.sort((a, b) => a - b);
  console.log(answer[K - count - 1]);
}
