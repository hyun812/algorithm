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

    while (this.heap[parent] && this.compare(this.heap[parent], this.heap[index])) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);
    let minIdx = index;

    if (this.heap[left] && this.compare(this.heap[minIdx], this.heap[left])) {
      minIdx = left;
    }

    if (this.heap[right] && this.compare(this.heap[minIdx], this.heap[right])) {
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

const T = +input[0];
let num = 1;
const answer = [];

for (let tc = 0; tc < T; tc++) {
  const M = +input[num];
  const lines = Math.floor(M / 10) + 1;

  answer.push(Math.floor(M / 2) + 1);

  const minHeap = new Heap((a, b) => a > b);
  const maxHeap = new Heap((a, b) => a < b);

  let result = [];
  for (let i = 0; i < lines; i++) {
    const line = input[num + i + 1].split(' ').map(Number);

    for (let j = 0; j < line.length; j++) {
      const target = line[j];

      minHeap.size() === maxHeap.size() ? maxHeap.enqueue(target) : minHeap.enqueue(target);

      if (minHeap.size() && maxHeap.size() && minHeap.peek() < maxHeap.peek()) {
        const min = minHeap.dequeue();
        const max = maxHeap.dequeue();

        minHeap.enqueue(max);
        maxHeap.enqueue(min);
      }

      if (j % 2 === 0) {
        if (result.length === 10) {
          answer.push(result.join(' '));
          result = [];
        }
        result.push(maxHeap.peek());
      }
    }
  }
  answer.push(result.join(' '));
  num += lines + 1;
}

console.log(answer.join('\n'));
