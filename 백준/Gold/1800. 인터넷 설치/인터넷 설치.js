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

  enqueue(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  dequeue() {
    if (this.size() === 0) return;
    if (this.size() === 1) return this.heap.pop();

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);

    return min;
  }
}

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, P, K] = input[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
let maxPrice = 0;
for (let i = 0; i < P; i++) {
  const [from, to, cost] = input[i + 1].split(' ').map(Number);

  graph[from].push([to, cost]);
  graph[to].push([from, cost]);

  maxPrice = Math.max(cost, maxPrice);
}

const dijkstra = (price) => {
  const queue = new Heap();
  const dist = Array(N + 1).fill(Infinity);

  queue.enqueue([1, 0]);
  dist[1] = 0;

  while (queue.size()) {
    const [cur, count] = queue.dequeue();

    if (dist[cur] < count) continue;

    for (const [next, nextCost] of graph[cur]) {
      let nextCount = count;

      if (nextCost > price) nextCount++;
      if (dist[next] > nextCount) {
        dist[next] = nextCount;
        queue.enqueue([next, dist[next]]);
      }
    }
  }

  return dist[N] <= K;
};

const binarySearch = () => {
  let answer = Infinity;
  let left = 0;
  let right = maxPrice;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    if (dijkstra(mid)) {
      right = mid - 1;
      answer = Math.min(answer, mid);
    } else {
      left = mid + 1;
    }
  }

  return answer === Infinity ? -1 : answer;
};

const answer = binarySearch();
console.log(answer);
/**
 * K개의 선 연결은 공짜
 * 이후 남은 선 연결은 제일 비싼 가격만
 *
 * 이때 최소 가격
 * 가격 기준으로 bfs or 다익스트라 돌리고
 * 그 가격이 성립될 때의 K의 개수를 찾음
 * 이분탐색
 *
 */
