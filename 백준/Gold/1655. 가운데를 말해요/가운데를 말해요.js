class Heap {
  constructor(compare) {
    this.heap = [];
    this.compare = compare;
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

    while (this.heap[parent] !== undefined && this.compare(this.heap[parent], this.heap[index])) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);
    let target = index;

    if (this.heap[left] !== undefined && this.compare(this.heap[target], this.heap[left])) {
      target = left;
    }

    if (this.heap[right] !== undefined && this.compare(this.heap[target], this.heap[right])) {
      target = right;
    }

    if (target !== index) {
      this.swap(target, index);
      this.bubbleDown(target);
    }
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

    const root = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);

    return root;
  }
}

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const N = +input[0];
const arr = input.slice(1).map(Number);
const answer = [];

const minHeap = new Heap((a, b) => a > b);
const maxHeap = new Heap((a, b) => a < b);

for (let i = 0; i < N; i++) {
  const target = arr[i];

  if (minHeap.size() === maxHeap.size()) {
    maxHeap.enqueue(target);
  } else {
    minHeap.enqueue(target);
  }

  if (minHeap.size() && maxHeap.size() && minHeap.peek() < maxHeap.peek()) {
    const min = minHeap.dequeue();
    const max = maxHeap.dequeue();

    minHeap.enqueue(max);
    maxHeap.enqueue(min);
  }

  answer.push(maxHeap.peek());
}

console.log(answer.join('\n'));