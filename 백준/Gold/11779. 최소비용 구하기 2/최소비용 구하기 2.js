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

const N = +input[0];
const M = +input[1];
const dist = Array(N + 1).fill(Infinity);
const graph = Array.from({ length: N + 1 }, () => []);
for (let i = 2; i < 2 + M; i++) {
  const [from, to, cost] = input[i].split(' ').map(Number);

  graph[from].push([to, cost]);
}

const [start, end] = input[M + 2].split(' ').map(Number);

const dijkstra = () => {
  const pq = new Heap();

  pq.push([start, 0, `${start}`]);
  dist[start] = 0;

  while (pq.size()) {
    const [cur, cost, path] = pq.pop();

    if (cur === end) {
      console.log(cost);
      console.log(path.split(' ').length);
      console.log(path);
      return;
    }

    if (cost > dist[cur]) continue;

    for (const [next, nextCost] of graph[cur]) {
      if (dist[next] > dist[cur] + nextCost) {
        dist[next] = dist[cur] + nextCost;
        pq.push([next, dist[next], path + ' ' + next]);
      }
    }
  }
};

dijkstra();
