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

    this.swap(index, minIdx);
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

const [N, M, X] = input[0].split(' ').map(Number);
const graph1 = Array.from({ length: N + 1 }, () => []);
const graph2 = Array.from({ length: N + 1 }, () => []);

for (let i = 0; i < M; i++) {
  const [from, to, time] = input[i + 1].split(' ').map(Number);
  graph1[from].push([to, time]);
  graph2[to].push([from, time]);
}

const dijkstra = (graph) => {
  const dist = Array(N + 1).fill(Infinity);
  const pq = new Heap();

  pq.enqueue([X, 0]);
  dist[X] = 0;

  while (pq.size()) {
    const [cur, t] = pq.dequeue();

    for (const [next, nextTime] of graph[cur]) {
      if (dist[next] > dist[cur] + nextTime) {
        dist[next] = dist[cur] + nextTime;
        pq.enqueue([next, dist[next]]);
      }
    }
  }

  return dist;
};

const go = dijkstra(graph1);
const back = dijkstra(graph2);

let answer = 0;
for (let i = 1; i <= N; i++) {
  answer = Math.max(answer, go[i] + back[i]);
}

console.log(answer);