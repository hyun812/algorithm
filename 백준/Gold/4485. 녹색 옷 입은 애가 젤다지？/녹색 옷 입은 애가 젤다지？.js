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

    while (this.heap[parent] && this.heap[parent][2] > this.heap[index][2]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] && this.heap[left][2] < this.heap[minIdx][2]) {
      minIdx = left;
    }

    if (this.heap[right] && this.heap[right][2] < this.heap[minIdx][2]) {
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

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const dijkstra = (n, map) => {
  const pq = new Heap();
  const dist = Array.from({ length: n }, () => Array(n).fill(Infinity));

  pq.enqueue([0, 0, map[0][0]]);
  dist[0][0] = map[0][0];

  while (pq.size()) {
    const [y, x, cost] = pq.dequeue();

    if (dist[y][x] < cost) continue;

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
      if (dist[ny][nx] > dist[y][x] + map[ny][nx]) {
        dist[ny][nx] = dist[y][x] + map[ny][nx];
        pq.enqueue([ny, nx, dist[ny][nx]]);
      }
    }
  }

  return dist[n - 1][n - 1];
};

const answer = [];
let tc = 1;
let num = 0;
while (true) {
  const n = +input[num];

  if (n === 0) break;

  const map = input.slice(num + 1, num + n + 1).map((lines) => lines.split(' ').map(Number));

  const result = dijkstra(n, map);

  answer.push(`Problem ${tc}: ${result}`);
  num += n + 1;
  tc++;
}

console.log(answer.join('\n'));