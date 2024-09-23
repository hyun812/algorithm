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

    while (this.heap[parent] && this.heap[parent] > this.heap[index]) {
      this.swap(index, parent);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] && this.heap[left] < this.heap[minIdx]) {
      minIdx = left;
    }

    if (this.heap[right] && this.heap[right] < this.heap[minIdx]) {
      minIdx = right;
    }

    if (minIdx === index) return;

    this.swap(index, minIdx);
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

  peek() {
    return this.heap[0];
  }
}

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];
const lectures = [];
for (let i = 0; i < N; i++) {
  const [start, end] = input[i + 1].split(' ').map(Number);
  lectures[i] = { start, end };
}

lectures.sort((a, b) => (a.start === b.start ? a.end - b.end : a.start - b.start));

const pq = new Heap();
pq.push(lectures[0].end);

for (let i = 1; i < N; i++) {
  if (pq.peek() <= lectures[i].start) {
    pq.pop();
  }
  pq.push(lectures[i].end);
}

console.log(pq.size());