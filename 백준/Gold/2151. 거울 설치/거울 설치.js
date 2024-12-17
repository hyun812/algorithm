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

    while (this.heap[parent] && this.heap[parent][3] > this.heap[index][3]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] && this.heap[left][3] < this.heap[minIdx][3]) {
      minIdx = left;
    }

    if (this.heap[right] && this.heap[right][3] < this.heap[minIdx][3]) {
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

const N = +input[0];
const house = input.slice(1).map((lines) => lines.slice(0, N).split(''));

const door = [];
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (house[i][j] === '#') door.push([i, j]);
  }
}

const dy = [-1, 0, 1, 0];
const dx = [0, 1, 0, -1];

const bfs = () => {
  const queue = new Heap();
  const visited = Array.from({ length: N }, () => Array.from({ length: N }, () => Array(4).fill(0)));

  const [sy, sx] = door[0];
  const [ey, ex] = door[1];

  for (let i = 0; i < 4; i++) {
    queue.enqueue([sy, sx, i, 0]);
  }

  while (queue.size()) {
    const [y, x, dir, cnt] = queue.dequeue();

    visited[y][x][dir] = 1;

    if (y === ey && x === ex) {
      return cnt;
    }

    const ny = y + dy[dir];
    const nx = x + dx[dir];

    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
    if (house[ny][nx] === '*') continue;
    if (visited[ny][nx][dir]) continue;

    if (house[ny][nx] === '!') {
      queue.enqueue([ny, nx, (dir + 1) % 4, cnt + 1]);
      queue.enqueue([ny, nx, (dir + 3) % 4, cnt + 1]);
    }

    queue.enqueue([ny, nx, dir, cnt]);
  }
};
console.log(bfs());