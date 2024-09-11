const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const arr = input[1].split(' ').map(Number);
const delete_node = +input[2];

let root = 0;
const tree = Array.from({ length: N }, () => []);
for (let i = 0; i < N; i++) {
  const target = arr[i];

  if (target === -1) {
    root = i;
    continue;
  }
  tree[target].push(i);
}

let answer = 0;
const dfs = (node) => {
  // 현재 노드를 부모로 갖는 노드가 없다면 리프노드
  if (!tree[node].length) {
    answer++;
    return;
  }

  for (const next of tree[node]) {
    if (next === delete_node) {
      // 자식이 삭제된 노드 밖에 없는 경우
      if (tree[node].length === 1) answer++;
      continue;
    }
    dfs(next);
  }
};

if (root !== delete_node) {
  dfs(root);
}

console.log(answer);