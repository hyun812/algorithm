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

    while (this.heap[parent] && this.heap[parent] > this.heap[index]) {
      this.swap(parent, index);
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

    this.swap(minIdx, index);
    this.bubbleDown(minIdx);
  }

  push(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  pop() {
    if (this.size() === 0) return 0;
    if (this.size() === 1) return this.heap.pop();

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);

    return min;
  }
}

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [N, ...input] = fs.readFileSync(filePath).toString().trim().split('\n').map(Number);

const heap = new Heap();
const answer = [];

input.forEach((v) => {
  if (v === 0) {
    answer.push(heap.pop());
  } else {
    heap.push(v);
  }
});

console.log(answer.join('\n'));