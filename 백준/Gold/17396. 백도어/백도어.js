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
      this.swap(index, parent);
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

  push(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  pop() {
    if (this.size() === 0) return;
    if (this.size() === 1) return this.heap.pop();

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);

    return min;
  }
}

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const watched = input[1].split(' ').map(Number);

const graph = Array.from({ length: N }, () => []);
for (let i = 2; i < 2 + M; i++) {
  const [from, to, cost] = input[i].split(' ').map(Number);

  graph[from].push([to, cost]);
  graph[to].push([from, cost]);
}

const heap = new Heap();
const dist = new Array(N).fill(Infinity);

heap.push([0, 0]);
dist[0] = 0;

while (heap.size()) {
  const [cur, cost] = heap.pop();

  if (watched[cur]) continue;
  if (dist[cur] < cost) continue;

  for (const next of graph[cur]) {
    const [nextNode, nextCost] = next;

    if (dist[nextNode] > dist[cur] + nextCost) {
      dist[nextNode] = dist[cur] + nextCost;
      heap.push([nextNode, dist[nextNode]]);
    }
  }
}

console.log(dist[N - 1] === Infinity ? -1 : dist[N - 1]);
