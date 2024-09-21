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

const T = +input[0];

const dfs = (start, end) => {
  const queue = new Queue();
  const visited = { [start]: true };

  queue.enqueue([start, '']);

  while (queue.size) {
    const [num, order] = queue.dequeue();

    if (num === end) {
      return order;
    }

    // D
    const newD = (num * 2) % 10000;
    if (!visited[newD]) {
      queue.enqueue([newD, order + 'D']);
      visited[newD] = true;
    }

    // S
    const newS = num === 0 ? 9999 : num - 1;
    if (!visited[newS]) {
      queue.enqueue([newS, order + 'S']);
      visited[newS] = true;
    }

    // L 1234 > 2341
    const newL = (num % 1000) * 10 + Math.floor(num / 1000);
    if (!visited[newL]) {
      queue.enqueue([newL, order + 'L']);
      visited[newL] = true;
    }

    // R 1234 > 4123
    const newR = (num % 10) * 1000 + Math.floor(num / 10);
    if (!visited[newR]) {
      queue.enqueue([newR, order + 'R']);
      visited[newR] = true;
    }
  }
};

const answer = [];
for (let tc = 1; tc <= T; tc++) {
  const [start, end] = input[tc].split(' ').map(Number);

  const order = dfs(start, end);
  answer.push(order);
}

console.log(answer.join('\n'));