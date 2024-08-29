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

const map = new Array(101).fill(0).map((_, idx) => idx);

for (let i = 1; i <= N + M; i++) {
  let [from, to] = input[i].split(' ').map(Number);
  map[from] = to;
}

const bfs = () => {
  const visited = new Array(101).fill(0);
  const queue = new Queue();
  queue.enqueue([1, 0]);
  visited[0] = 1;

  while (queue.size) {
    const [cur, cnt] = queue.dequeue();

    if (cur === 100) {
      return cnt;
    }

    for (let i = 1; i <= 6; i++) {
      const next = cur + i;

      if (next >= 101) continue;
      if (visited[next]) continue;

      queue.enqueue([map[next], cnt + 1]);
      visited[next] = 1;
    }
  }
};

const count = bfs();

console.log(count);