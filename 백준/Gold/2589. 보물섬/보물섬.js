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

const map = [];
for (let i = 0; i < N; i++) {
  map.push(input[i + 1].slice(0, M).split(''));
}

let answer = 0;

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const bfs = (startY, startX) => {
  const queue = new Queue();
  const visited = Array.from({ length: N }, () => Array(M).fill(0));

  queue.enqueue([startY, startX, 0]);
  visited[startY][startX] = 1;

  while (queue.size) {
    const [y, x, length] = queue.dequeue();

    answer = Math.max(answer, length);

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
      if (map[ny][nx] === 'W') continue;
      if (visited[ny][nx]) continue;

      visited[ny][nx] = 1;
      queue.enqueue([ny, nx, length + 1]);
    }
  }
};

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (map[i][j] === 'W') continue;
    bfs(i, j);
  }
}

console.log(answer);