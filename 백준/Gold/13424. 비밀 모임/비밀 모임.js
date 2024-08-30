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
    while (this.heap[parent] && this.heap[index].cost < this.heap[parent].cost) {
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
    if (left < this.heap.length && this.heap[left].cost < this.heap[minIdx].cost) {
      minIdx = left;
    }
    // 오른쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작은 경우
    if (right < this.heap.length && this.heap[right].cost < this.heap[minIdx].cost) {
      minIdx = right;
    }

    // 내가 젤 작음
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

const dijkstra = (start, graph, dist) => {
  const pq = new Heap();
  pq.push({ v: start, cost: 0 });
  dist[start] = 0;

  while (pq.size()) {
    const cur = pq.pop();

    if (cur.cost > dist[cur.v]) continue;

    for (const next of graph[cur.v]) {
      if (dist[next.v] > dist[cur.v] + next.cost) {
        dist[next.v] = dist[cur.v] + next.cost;
        pq.push({ v: next.v, cost: dist[next.v] });
      }
    }
  }

  return dist;
};

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const tc = +input[0];

let count = 1;
for (let t = 0; t < tc; t++) {
  let answer = 0;
  let sum = Infinity;
  const [N, M] = input[count].split(' ').map(Number);

  const graph = Array.from({ length: N + 1 }, () => []);
  for (let i = count + 1; i <= count + M; i++) {
    const [from, to, cost] = input[i].split(' ').map(Number);

    graph[from].push({ v: to, cost: cost });
    graph[to].push({ v: from, cost: cost });
  }

  const friend = +input[count + M + 1];
  const friends = input[count + M + 2].split(' ').map(Number);

  for (let i = 1; i <= N; i++) {
    let dist = Array(N + 1).fill(Infinity);

    const path = dijkstra(i, graph, dist);

    let result = 0;
    for (let j = 0; j < friend; j++) {
      result += path[friends[j]];
    }
    if (sum > result) {
      answer = i;
      sum = result;
    }
  }

  console.log(answer);
  count += M + 3;
}