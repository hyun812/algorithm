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

const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [W, H] = input[0].split(' ').map(Number);
const houses = Array.from({ length: H + 2 }, () => Array(W + 2).fill(0));
const visited = Array.from({ length: H + 2 }, () => Array(W + 2).fill(0));

for (let i = 1; i <= H; i++) {
  const lines = input[i].split(' ').map(Number);
  for (let j = 1; j <= W; j++) {
    houses[i][j] = lines[j - 1];
  }
}

// 홀수
const oddDy = [-1, 0, -1, 1, 1, 0];
const oddDx = [0, -1, 1, 0, 1, 1];
// 짝수
const evenDy = [-1, -1, 0, 1, 0, 1];
const evenDx = [0, -1, -1, 0, 1, -1];

let answer = 0;
const bfs = () => {
  const queue = new Queue();

  queue.enqueue([0, 0]);
  visited[0][0] = 1;

  while (queue.size) {
    const [y, x] = queue.dequeue();

    const [dy, dx] = y % 2 === 0 ? [evenDy, evenDx] : [oddDy, oddDx];

    for (let i = 0; i < 6; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= H + 2 || nx >= W + 2) continue;
      if (visited[ny][nx]) continue;
      if (houses[ny][nx]) {
        answer++;
        continue;
      }

      queue.enqueue([ny, nx]);
      visited[ny][nx] = 1;
    }
  }
};

bfs();

console.log(answer);