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

// N: 샘터의 개수
// K: 집의 개수
const [N, K] = input[0].split(' ').map(Number);
const rest = input[1].split(' ').map(Number);

const queue = new Queue();
const visited = new Map();
for (let i = 0; i < N; i++) {
  visited.set(rest[i], true);
  queue.enqueue([rest[i], 0]);
}

const dx = [-1, 1];
const bfs = () => {
  let cnt = 0;
  let dist = 0;
  while (queue.size) {
    const cur = queue.dequeue();

    for (let i = 0; i < 2; i++) {
      const next = cur[0] + dx[i];

      if (visited.has(next)) continue;

      dist += cur[1] + 1;
      cnt++;

      if (cnt === K) return dist;
      visited.set(next, true);
      queue.enqueue([next, cur[1] + 1]);
    }
  }
};

console.log(bfs());