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

const n = +input[0];
const map = input.slice(1).map((lines) => lines.split('').map(Number));
const dist = Array.from({ length: n }, () => Array(n).fill(Infinity));

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const bfs = () => {
  const queue = new Queue();

  queue.enqueue([0, 0]);
  dist[0][0] = 0;

  while (queue.size) {
    const [y, x] = queue.dequeue();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

      if (map[ny][nx] === 0) {
        if (dist[ny][nx] > dist[y][x] + 1) {
          dist[ny][nx] = dist[y][x] + 1;
          queue.enqueue([ny, nx]);
        }
      } else if (map[ny][nx] === 1) {
        if (dist[ny][nx] > dist[y][x]) {
          dist[ny][nx] = dist[y][x];
          queue.enqueue([ny, nx]);
        }
      }
    }
  }
};

bfs();

console.log(dist[n - 1][n - 1]);