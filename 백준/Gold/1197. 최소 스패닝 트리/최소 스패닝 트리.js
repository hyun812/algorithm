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
const graph = Array.from({ length: V + 1 }, () => []);

const prim = () => {
  let answer = 0;
  const pq = new Heap();
  const visited = Array(V + 1).fill(0);

  pq.enqueue([1, 0]);

  while (pq.size()) {
    const [cur, weight] = pq.dequeue();

    if (visited[cur]) continue;
    visited[cur] = 1;
    answer += weight;

    for (const [next, nextWeight] of graph[cur]) {
      if (visited[next]) continue;

      pq.enqueue([next, nextWeight]);
    }
  }

  return answer;
};

for (let i = 0; i < E; i++) {
  const [from, to, weight] = input[i + 1].split(' ').map(Number);

  graph[from].push([to, weight]);
  graph[to].push([from, weight]);
}

const answer = prim();
console.log(answer);