const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const n = +input[0];
const visited = Array.from({ length: n }, () => Array(10).fill(0));
const graph = Array.from({ length: n }, () => []);
const results = Array(n).fill(-1);
let flag = false;

for (let i = 1; i <= n; i++) {
  const [m, ...type] = input[i].split(' ').map(Number);
  graph[i - 1] = type;
}

const dfs = (prev, day) => {
  if (flag) return;
  if (day === n) {
    flag = true;
    return;
  }

  for (const type of graph[day]) {
    if (flag) return;
    if (type === prev) continue;
    if (visited[day][type]) continue;

    visited[day][type] = 1;
    results[day] = type;
    dfs(type, day + 1);
  }
};

dfs(-1, 0);

if (results[n - 1] === -1) {
  console.log(-1);
} else {
  console.log(results.join('\n'));
}
/**
 * 전날에 먹었던 떡은 먹지 않는다
 * n: 떡을 팔아야 할 날의 수
 * 입력 예시
 * 3 1 2 3
 * 첫번째날 3개의 떡을 가지고 감 -> 떡의 종류 1, 2, 3
 */