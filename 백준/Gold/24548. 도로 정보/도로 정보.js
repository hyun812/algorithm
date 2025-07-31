const fs = require("fs");
// const [N, ...input] = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");

const [N, str] = input;

// 나무 T, 잔디 G, 울타리 F, 사람 P
// 길이가 1 이상인 도로구간 중 그에 속한 모든 물체의 수가 3의 배수
// 흥미로운 구간이 될 수 있는 구간의 개수
const dp = Array.from({ length: 3 }, () =>
  Array.from({ length: 3 }, () =>
    Array.from({ length: 3 }, () => Array(3).fill(0))
  )
);

let TCnt = 0;
let GCnt = 0;
let FCnt = 0;
let PCnt = 0;

let ans = 0;

// 초기 상태
dp[0][0][0][0] = 1;

for (const type of str) {
  if (type === "T") TCnt = (TCnt + 1) % 3;
  else if (type === "G") GCnt = (GCnt + 1) % 3;
  else if (type === "F") FCnt = (FCnt + 1) % 3;
  else if (type === "P") PCnt = (PCnt + 1) % 3;

  ans += dp[TCnt][GCnt][FCnt][PCnt];
  dp[TCnt][GCnt][FCnt][PCnt] += 1;
}

console.log(ans);
