const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input.shift();
const tree = Array.from({ length: N + 1 }, () => []);

for (const node of input) {
  const [from, to, cost] = node.split(' ').map(Number);

  tree[from].push([to, cost]);
  tree[to].push([from, cost]);
}

const dfs = (start) => {
  const visited = new Array(N + 1).fill(0);
  let [maxNode, maxCost] = [0, 0];
  const queue = [[start, 0]];

  visited[start] = 1;

  while (queue.length) {
    const [cur, cost] = queue.shift();

    for (const [nextNode, nextCost] of tree[cur]) {
      if (visited[nextNode]) continue;

      if (maxCost < cost + nextCost) {
        maxCost = cost + nextCost;
        maxNode = nextNode;
      }

      visited[nextNode] = 1;
      queue.push([nextNode, cost + nextCost]);
    }
  }

  return [maxNode, maxCost];
};

const [mN] = dfs(1);

console.log(dfs(mN)[1]);