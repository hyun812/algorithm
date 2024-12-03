class Heap {
  constructor() {
    this.heap = [];
  }

  size() {
    return this.heap.length;
  }

  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }

  getParent(index) {
    return Math.floor((index - 1) / 2);
  }

  getLeftChild(index) {
    return index * 2 + 1;
  }

  getRightChild(index) {
    return index * 2 + 2;
  }

  bubbleUp() {
    let index = this.heap.length - 1;
    let parent = this.getParent(index);

    while (this.heap[parent] && this.heap[parent][1] > this.heap[index][1]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] && this.heap[left][1] < this.heap[minIdx][1]) {
      minIdx = left;
    }

    if (this.heap[right] && this.heap[right][1] < this.heap[minIdx][1]) {
      minIdx = right;
    }

    if (minIdx === index) return;

    this.swap(minIdx, index);
    this.bubbleDown(minIdx);
  }

  enqueue(data) {
    this.heap.push(data);
    this.bubbleUp();
  }

  dequeue() {
    if (!this.size()) return null;
    if (this.size() === 1) return this.heap.pop();

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);

    return min;
  }
}

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [V, E] = input[0].split(' ').map(Number);
const graph = [];

for (let i = 0; i < E; i++) {
  const node = input[i + 1].split(' ').map(Number);
  graph.push(node);
}

const parents = Array(V + 1)
  .fill(0)
  .map((_, i) => i);

const find = (a) => {
  if (parents[a] === a) return a;

  return (parents[a] = find(parents[a]));
};

const union = (a, b) => {
  const aRoot = find(a);
  const bRoot = find(b);

  if (aRoot === bRoot) return false;

  parents[bRoot] = aRoot;
  return true;
};

graph.sort((a, b) => a[2] - b[2]);

let answer = 0;
let count = 0;
for (const [from, to, weight] of graph) {
  if (union(from, to)) {
    answer += weight;
    count++;
    if (count === V - 1) break;
  }
}

console.log(answer);