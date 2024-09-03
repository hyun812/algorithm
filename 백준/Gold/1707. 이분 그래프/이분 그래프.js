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

const bfs = (start, graph, visited) => {
  const queue = new Queue();

  queue.enqueue(start);
  visited[start] = 1;

  while (queue.size) {
    const cur = queue.dequeue();

    for (const next of graph[cur]) {
      if (visited[next]) continue;

      visited[next] = visited[cur] * -1;
      queue.enqueue(next);
    }
  }
};

const check = (V, visited, graph) => {
  for (let i = 1; i <= V; i++) {
    for (const next of graph[i]) {
      if (visited[i] === visited[next]) {
        return 'NO';
      }
    }
  }
  return 'YES';
};

const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const TC = +input[0];
let num = 1;
const answer = [];

for (let t = 1; t <= TC; t++) {
  const [V, E] = input[num].split(' ').map(Number);
  const graph = Array.from({ length: V + 1 }, () => []);
  const visited = new Array(V + 1).fill(0); // 미방문: 0, 검정색: 1, 하얀색: -1

  for (let i = 1; i <= E; i++) {
    const [from, to] = input[num + i].split(' ').map(Number);
    graph[from].push(to);
    graph[to].push(from);
  }

  for (let i = 1; i <= V; i++) {
    if (visited[i]) continue;
    bfs(i, graph, visited);
  }

  answer.push(check(V, visited, graph));

  num += E + 1;
}

console.log(answer.join('\n'));