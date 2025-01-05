const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const tree = {};
for (let i = 1; i <= N + M; i++) {
  const [P, F, C] = input[i].split(' ');

  if (tree[P]) {
    tree[P].push([F, +C]);
  } else {
    tree[P] = [];
    tree[P].push([F, +C]);
  }
}

const [count, ...queries] = input.slice(N + M + 1).map((v) => v.trim());
const bfs = (query) => {
  const queue = [];
  const fileCheck = new Set();
  let count = 0;

  queue.push([query]);

  while (queue.length) {
    const [cur] = queue.shift();

    if (!tree[cur]) continue;

    for (const next of tree[cur]) {
      const [name, type] = next;

      if (type) {
        queue.push([name]);
      } else {
        // 파일이라면
        count++;
        fileCheck.add(name);
      }
    }
  }

  return [fileCheck.size, count];
};

const answer = [];
queries.forEach((query) => {
  const result = bfs(query.split('/').at(-1));
  answer.push(result.join(' '));
});

console.log(answer.join('\n'));