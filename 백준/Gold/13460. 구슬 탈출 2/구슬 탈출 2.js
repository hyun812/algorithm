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
let R = {};
let B = {};

for (let i = 1; i <= N; i++) {
  const row = input[i].slice(0, M).split('');
  map.push(row);
  if (row.includes('R')) R = { y: i - 1, x: row.indexOf('R') };
  if (row.includes('B')) B = { y: i - 1, x: row.indexOf('B') };
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

const outOfIdx = (y, x) => {
  if (y >= 0 && x >= 0 && y < N && x < M) {
    return true;
  }

  return false;
};
const move = (y, x, dy, dx) => {
  let cnt = 0;
  while (outOfIdx(y + dy, x + dx) && map[y + dy][x + dx] !== '#' && map[y][x] !== 'O') {
    y += dy;
    x += dx;
    cnt += 1;
  }
  return [y, x, cnt];
};

const bfs = () => {
  const queue = new Queue();
  const visited = new Set();

  queue.enqueue([R, B, 0]);
  visited.add(`${R.y}${R.x}${B.y}${B.x}`);

  while (queue.size) {
    const [r, b, c] = queue.dequeue();
    if (c > 10) return -1;

    for (let i = 0; i < 4; i++) {
      let [ry, rx, rCnt] = move(r.y, r.x, dy[i], dx[i]);
      let [by, bx, bCnt] = move(b.y, b.x, dy[i], dx[i]);

      if (map[by][bx] === 'O') continue;
      if (map[ry][rx] === 'O' && c + 1 <= 10) return c + 1;
      if (ry === by && rx === bx) {
        if (rCnt > bCnt) {
          ry -= dy[i];
          rx -= dx[i];
        } else if (rCnt < bCnt) {
          by -= dy[i];
          bx -= dx[i];
        }
      }

      const key = `${ry}${rx}${by}${bx}`;
      if (visited.has(key)) continue;

      queue.enqueue([{ y: ry, x: rx }, { y: by, x: bx }, c + 1]);
      visited.add(key);
    }
  }
  return -1;
};

console.log(bfs());