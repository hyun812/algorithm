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

const [N, M] = input[0].split(' ').map(Number);
const map = [];
for (let i = 1; i <= N; i++) {
  map.push(input[i].split(' ').map(Number));
}

const [H, W, startY, startX, endY, endX] = input[N + 1].split(' ').map(Number);

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const preSum = Array.from({ length: N }, () => Array(M).fill(0));
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    const cur = map[i][j];
    const left = j > 0 ? preSum[i][j - 1] : 0;
    const up = i > 0 ? preSum[i - 1][j] : 0;
    const diagonal = i > 0 && j > 0 ? preSum[i - 1][j - 1] : 0;

    preSum[i][j] = cur + left + up - diagonal;
  }
}

const outOfIndex = (y, x) => {
  if (y >= 0 && x >= 0 && y < N && x < M) {
    return true;
  }
  return false;
};

const getPrefixSum = (y, x) => {
  if (y < 0 || x < 0) return 0;

  return preSum[y][x];
};

const bfs = () => {
  const queue = new Queue();
  const visited = Array.from({ length: N }, () => Array(M).fill(0));

  queue.enqueue([startY - 1, startX - 1, 0]);
  visited[startY - 1][startX - 1] = 1;

  while (queue.size) {
    const [curY, curX, count] = queue.dequeue();

    if (curY === endY - 1 && curX === endX - 1) {
      console.log(count);
      return;
    }

    for (let i = 0; i < 4; i++) {
      const [a, b] = [curY + dy[i], curX + dx[i]];
      const [c, d] = [a + H - 1, b + W - 1];

      if (!outOfIndex(a, b)) continue;
      if (c >= N || d >= M) continue;
      if (visited[a][b]) continue;
      if (map[a][b]) continue;

      const wall = getPrefixSum(c, d) - getPrefixSum(a - 1, d) - getPrefixSum(c, b - 1) + getPrefixSum(a - 1, b - 1);
      if (wall) continue;

      visited[a][b] = 1;
      queue.enqueue([a, b, count + 1]);
    }
  }
  console.log(-1);
};

bfs();