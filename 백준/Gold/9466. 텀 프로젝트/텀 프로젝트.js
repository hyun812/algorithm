const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [T, ...input] = fs.readFileSync(filePath).toString().trim().split('\n');

const answer = [];
let num = 0;
for (let tc = 0; tc < T; tc++) {
  const n = +input[num];
  const arr = [0, ...input[num + 1].split(' ').map(Number)];
  let visited = Array(n + 1).fill(0);
  let done = Array(n + 1).fill(0);
  let count = 0;

  const dfs = (start) => {
    if (done[start]) return; // 이미 팀이 편성됐다면
    if (visited[start]) {
      // 사이클
      done[start] = 1;
      count++;
    }

    visited[start] = 1;
    dfs(arr[start]);
    visited[start] = 0;
    done[start] = 1;
  };

  for (let i = 1; i <= n; i++) {
    if (done[i]) continue;
    dfs(i);
  }

  answer.push(n - count);
  num += 2;
}

console.log(answer.join('\n'));
