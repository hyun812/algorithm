class MinHeap {
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

    while (this.heap[parent] !== undefined && this.heap[parent] > this.heap[index]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] !== undefined && this.heap[left] < this.heap[minIdx]) {
      minIdx = left;
    }

    if (this.heap[right] !== undefined && this.heap[right] < this.heap[minIdx]) {
      minIdx = right;
    }

    if (minIdx === index) return;

    this.swap(minIdx, index);
    this.bubbleDown(minIdx);
  }

  peek() {
    return this.size() ? this.heap[0] : null;
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

class MaxHeap {
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

    while (this.heap[parent] !== undefined && this.heap[parent] < this.heap[index]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] !== undefined && this.heap[left] > this.heap[minIdx]) {
      minIdx = left;
    }

    if (this.heap[right] !== undefined && this.heap[right] > this.heap[minIdx]) {
      minIdx = right;
    }

    if (minIdx === index) return;

    this.swap(minIdx, index);
    this.bubbleDown(minIdx);
  }

  peek() {
    return this.size() ? this.heap[0] : null;
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
const arr = input.slice(1).map(Number);
const answer = [];

const minHeap = new MinHeap();
const maxHeap = new MaxHeap();

for (let i = 0; i < N; i++) {
  const target = arr[i];

  minHeap.size() === maxHeap.size() ? maxHeap.enqueue(target) : minHeap.enqueue(target);

  if (minHeap.size() && maxHeap.size() && minHeap.peek() < maxHeap.peek()) {
    const min = minHeap.dequeue();
    const max = maxHeap.dequeue();

    minHeap.enqueue(max);
    maxHeap.enqueue(min);
  }

  answer.push(maxHeap.peek());
}

console.log(answer.join('\n'));