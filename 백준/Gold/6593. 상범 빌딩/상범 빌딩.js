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

const dz = [0, 0, 0, 0, -1, 1];
const dy = [-1, 1, 0, 0, 0, 0];
const dx = [0, 0, -1, 1, 0, 0];

const answer = [];
while (input.length > 1) {
  const [L, R, C] = input.shift().split(' ').map(Number);

  //빌딩 만들기
  const building = input.splice(0, (R + 1) * L).reduce(
    (r, v) => {
      if (v == '') {
        r.push([]);
      } else {
        r[r.length - 1].push(v.split(''));
      }
      return r;
    },
    [[]]
  );
  building.pop();

  // 상범이의 모험
  const result = solution(L, R, C, building);
  answer.push(result);
}
console.log(answer.join('\n'));

function solution(L, R, C, building) {
  let start = [];
  let end = [];
  let visited = Array.from({ length: L }, () => Array.from({ length: R }, () => Array(C).fill(0)));

  for (let i = 0; i < L; i++) {
    for (let j = 0; j < R; j++) {
      for (let k = 0; k < C; k++) {
        if (building[i][j][k] === 'S') {
          start = [i, j, k];
        } else if (building[i][j][k] === 'E') {
          end = [i, j, k];
        }
      }
    }
  }

  const queue = new Queue();

  queue.enqueue([...start, 0]);
  visited[start[0]][start[1]][start[2]] = 1;

  while (queue.size) {
    const [z, y, x, len] = queue.dequeue();

    if (z === end[0] && y === end[1] && x === end[2]) {
      return `Escaped in ${len} minute(s).`;
    }

    for (let i = 0; i < 6; i++) {
      const nz = z + dz[i];
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C) continue;
      if (building[nz][ny][nx] === '#') continue;
      if (visited[nz][ny][nx]) continue;

      visited[nz][ny][nx] = 1;
      queue.enqueue([nz, ny, nx, len + 1]);
    }
  }
  return 'Trapped!';
}