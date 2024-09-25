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

  push(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  pop() {
    if (!this.size()) return null;
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

const [N, D] = input[0].split(' ').map(Number);

const graph = Array.from({ length: D + 1 }, () => []);
const dist = Array(D + 1).fill(Infinity);
for (let i = 1; i <= N; i++) {
  const [from, to, cost] = input[i].split(' ').map(Number);

  if (to > D) continue;
  if (to - from <= cost) continue;

  graph[from].push([to, cost]);
}

const dijkstra = () => {
  const pq = new Heap();

  pq.push([0, 0]); // 현재 위치, 현재 비용
  dist[0] = 0;

  while (pq.size()) {
    const [cur, cost] = pq.pop();

    if (cost > dist[cur]) continue;
    if (cur + 1 <= D && cost + 1 < dist[cur + 1]) {
      dist[cur + 1] = cost + 1;
      pq.push([cur + 1, cost + 1]);
    }

    for (const [next, nextCost] of graph[cur]) {
      if (dist[next] > dist[cur] + nextCost) {
        dist[next] = dist[cur] + nextCost;
        pq.push([next, dist[next]]);
      }
    }
  }
};

dijkstra();

console.log(dist[D]);