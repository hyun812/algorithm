class Node {
  constructor(data) {
    this.data = data;
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

const [n, m] = input[0].split(' ').map(Number);
const map = [];
let [endY, endX] = [-1, -1];
let check = false;
for (let i = 1; i <= n; i++) {
  const row = input[i].split(' ').map(Number);
  map.push(row);

  if (!check && row.includes(2)) {
    endY = i - 1;
    endX = row.indexOf(2);
    check = true;
  }
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
const visited = Array.from({ length: n }, () => Array(m).fill(0));
const dist = Array.from({ length: n }, () => Array(m).fill(0));

const bfs = () => {
  const queue = new Queue();

  queue.enqueue([endY, endX, 0]);
  visited[endY][endX] = 1;

  while (queue.size) {
    const [y, x, count] = queue.dequeue();

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny < 0 || nx < 0 || ny >= n || ny >= m) continue;
      if (visited[ny][nx]) continue;
      if (!map[ny][nx]) continue;

      queue.enqueue([ny, nx, count + 1]);
      dist[ny][nx] = dist[y][x] + 1;
      visited[ny][nx] = 1;
    }
  }
};

bfs();

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (!visited[i][j] && map[i][j] === 1) {
      dist[i][j] = -1;
    }
  }
  console.log(dist[i].join(' '));
}