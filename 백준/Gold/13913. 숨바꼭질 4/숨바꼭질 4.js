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

/**
 * 걷거나 순간이동이 가능
 * 걷는다면 x-1 || x+1
 * 순간이동한다면 x*2
 * 가장 빠른시간이 몇초 후인지
 */

const [N, K] = input[0].split(' ').map(Number);

const bfs = () => {
  const queue = new Queue();
  const visited = new Array(100001).fill(0);

  queue.enqueue([N, `${N}`]);
  visited[N] = 1;

  while (queue.size) {
    const [cur, path] = queue.dequeue();

    if (cur === K) return path;

    for (const next of [cur - 1, cur + 1, cur * 2]) {
      if (visited[next]) continue;
      if (next < 0 || next > 100000) continue;

      visited[next] = 1;
      queue.enqueue([next, path + ' ' + `${next}`]);
    }
  }
};

const path = bfs();
console.log(path.split(' ').length - 1);
console.log(path);