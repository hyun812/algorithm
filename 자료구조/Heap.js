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

    // 부모 노드가 존재하고, 새로운 노드가 부모 노드보다 작은 경우
    while (this.heap[parent] && this.heap[index] < this.heap[parent]) {
      this.swap(parent, index);
      index = parent;
      parent = this.getParent(index);
    }
  }

  bubbleDown(index) {
    let left = this.getLeftChild(index);
    let right = this.getRightChild(index);

    let minIdx = index;

    // 왼쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작거나
    if (left < this.heap.length && this.heap[left] < this.heap[minIdx]) {
      minIdx = left;
    }
    // 오른쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작은 경우
    if (right < this.heap.length && this.heap[right] < this.heap[minIdx]) {
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
    if (this.heap.length === 0) return;

    if (this.heap.length === 1) {
      return this.heap.pop();
    }

    const min = this.heap[0];
    this.heap[0] = this.heap.pop(); // 제일 뒤에 있는 원소를 제일 앞으로
    this.bubbleDown(0);

    return min;
  }
}
