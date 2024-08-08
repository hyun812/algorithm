const fs = require('fs');
const [N, ...input] = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
// const [N, ...input] = fs.readFileSync('index.txt').toString().trim().split('\n');

const tree = {};
for (let i = 0; i < N; i++) {
  const [node, left, right] = input[i].split(' ').map((v) => v.replace(/[^A-Z ]/g, ''));
  tree[node] = [left, right];
}

let result = '';
function preOrder(node) {
  if (node === '') return;
  const [left, right] = tree[node];
  result += node;
  preOrder(left);
  preOrder(right);
}

function inOrder(node) {
  if (node === '') return;
  const [left, right] = tree[node];
  inOrder(left);
  result += node;
  inOrder(right);
}

function postOrder(node) {
  if (node === '') return;
  const [left, right] = tree[node];
  postOrder(left);
  postOrder(right);
  result += node;
}

preOrder('A');
result += '\n';
inOrder('A');
result += '\n';
postOrder('A');
result += '\n';

console.log(result);