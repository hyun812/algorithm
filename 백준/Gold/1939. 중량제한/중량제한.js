class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  enqueue(data) {
    const newNode = new Node(data);

    if (!this.size) this.front = newNode;
    else this.rear.next = newNode;

    this.rear = newNode;
    this.size++;
  }

  dequeue() {
    if (!this.size) return null;

    const data = this.front.data;
    this.front = this.front.next;
    this.size--;
    return data;
  }
}

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
let max = 0;
let answer = 0;
for (let i = 1; i <= M; i++) {
  const [a, b, cost] = input[i].split(' ').map(Number);
  graph[a].push([b, cost]);
  graph[b].push([a, cost]);

  max = Math.max(max, cost);
}

const [a, b] = input[M + 1].split(' ').map(Number);

const bfs = (weight) => {
  const visited = Array(N + 1).fill(0);
  const queue = new Queue();

  visited[a] = 1;
  queue.enqueue(a);

  while (queue.size) {
    const cur = queue.dequeue();

    if (cur === b) return true;

    for (const next of graph[cur]) {
      const [nextNode, nextCost] = next;

      if (visited[nextNode]) continue;
      if (nextCost < weight) continue;

      visited[nextNode] = 1;
      queue.enqueue(nextNode);
    }
  }
  return false;
};

const binarySearch = () => {
  let left = 1;
  let right = max;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    if (bfs(mid)) {
      left = mid + 1;
      answer = Math.max(answer, mid);
    } else {
      right = mid - 1;
    }
  }
};

binarySearch();

console.log(answer);