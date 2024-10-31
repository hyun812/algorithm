class Heap {
  constructor() {
    this.heap = [];
  }

  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }

  size() {
    return this.heap.length;
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
      this.swap[(index, parent)];
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let min = index;

    if (this.heap[left] && this.heap[left][1] < this.heap[min][1]) {
      min = left;
    }

    if (this.heap[right] && this.heap[right][1] < this.heap[min][1]) {
      min = right;
    }

    if (min === index) return;

    this.swap(min, index);
    this.bubbleDown(min);
  }

  push(data) {
    this.heap.push(data);
    this.bubbleUp();
  }

  pop() {
    if (!this.size()) return null;
    if (this.size() === 1) return this.heap.pop();

    const data = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);

    return data;
  }
}

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, D] = input[0].split(' ').map(Number);
const graph = Array.from({ length: D + 1 }, () => []);
const dist = Array(D + 1).fill(Infinity);

for (let i = 0; i < N; i++) {
  const [from, to, cost] = input[i + 1].split(' ').map(Number);

  if (from > D || to > D) continue;
  if (to - from <= cost) continue;

  graph[from].push([to, cost]);
}

const dijkstra = () => {
  const pq = new Heap();

  pq.push([0, 0]);
  dist[0] = 0;

  while (pq.size()) {
    const [cur, cost] = pq.pop();

    if (cost > dist[cur]) continue;
    if (cur < D && cost + 1 < dist[cur + 1]) {
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