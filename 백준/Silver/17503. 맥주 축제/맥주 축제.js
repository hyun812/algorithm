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

    while (this.heap[parent] && this.heap[parent][0] > this.heap[index][0]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    if (this.heap[left] && this.heap[left][0] < this.heap[minIdx][0]) {
      minIdx = left;
    }

    if (this.heap[right] && this.heap[right][0] < this.heap[minIdx][0]) {
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

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M, K] = input[0].split(' ').map(Number);
const beers = input.slice(1, K + 1).map((lines) => lines.split(' ').map(Number));

// 도수순으로 정렬
beers.sort((a, b) => a[1] - b[1]);

let sum = 0;
const pq = new Heap();
let idx = 0;

for (; idx < N; idx++) {
  sum += beers[idx][0];
  pq.enqueue(beers[idx]);
}

while (idx < beers.length && sum < M) {
  let lowestBeer = pq.dequeue();
  sum -= lowestBeer[0];

  pq.enqueue(beers[idx]);
  sum += beers[idx][0];
  idx++;
}

// 결과 출력
if (sum < M) {
  console.log(-1);
} else {
  let maxAlcohol = 0;
  while (pq.size() > 0) {
    maxAlcohol = Math.max(maxAlcohol, pq.dequeue()[1]);
  }
  console.log(maxAlcohol);
}