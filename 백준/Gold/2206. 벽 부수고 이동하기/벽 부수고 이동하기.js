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

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map((lines) => lines.slice(0, M).split('').map(Number));

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const bfs = () => {
  const queue = new Queue();
  const visited = Array.from({ length: 2 }, () => Array.from({ length: N }, () => Array(M).fill(0)));

  queue.enqueue([0, 0, 1, 0]);
  visited[0][0][0] = 1;

  while (queue.size) {
    const [y, x, dist, destroy] = queue.dequeue();

    if (y === N - 1 && x === M - 1) {
      return dist;
    }

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
      if (map[ny][nx]) {
        if (destroy === 1) continue; // 이미 벽을 부쉈다면
        if (visited[destroy][ny][nx]) continue;

        visited[1][ny][nx] = 1;
        queue.enqueue([ny, nx, dist + 1, destroy + 1]);
      } else {
        if (visited[destroy][ny][nx]) continue;

        visited[destroy][ny][nx] = 1;
        queue.enqueue([ny, nx, dist + 1, destroy]);
      }
    }
  }

  return -1;
};

console.log(bfs());
