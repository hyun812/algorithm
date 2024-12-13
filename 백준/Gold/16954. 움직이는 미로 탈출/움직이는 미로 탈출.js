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

const board = input.slice(0, 8).map((lines) => lines.slice(0, 8).split(''));

/**
 * 상하좌우, 대각선, 현재위치로 이동가능
 * 이동할때는 빈칸으로만 이동가능
 * 캐릭터 이동 후 벽이동
 * 이때 벽이 캐릭터가 있는 곳으로 이동했다면 캐릭더 이동 불가
 * (7, 0)에서 (0, 7)으로 이동가능한지
 * 이동 가능: 1 , 불가능: 0
 */

const moveWall = () => {
  for (let i = 7; i >= 0; i--) {
    for (let j = 0; j < 8; j++) {
      if (board[i][j] !== '#') continue;

      board[i][j] = '.';
      if (i !== 7) board[i + 1][j] = '#';
    }
  }
};

const dy = [0, -1, 1, 0, 0, -1, 1, 1, -1];
const dx = [0, 0, 0, -1, 1, 1, 1, -1, -1];
const bfs = () => {
  const queue = new Queue();
  const visited = Array.from({ length: 8 }, () => Array.from({ length: 8 }, () => Array(9).fill(0)));
  queue.enqueue([7, 0, 0]);

  while (queue.size) {
    const queueSize = queue.size;

    for (let i = 0; i < queueSize; i++) {
      const [y, x, depth] = queue.dequeue();

      if (board[y][x] === '#') continue;
      if (y === 0 && x === 7) return 1;
      if (depth >= 8) return 1;

      for (let i = 0; i < 9; i++) {
        const ny = y + dy[i];
        const nx = x + dx[i];

        if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8) continue;
        if (board[ny][nx] === '#') continue;
        if (visited[ny][nx][depth + 1]) continue;

        queue.enqueue([ny, nx, depth + 1]);
        visited[ny][nx][depth + 1] = 1;
      }
    }
    moveWall();
  }

  return 0;
};

console.log(bfs());