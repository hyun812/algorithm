class Node {
	constructor(item) {
		this.item = item;
		this.next = null;
	}
}

class Queue {
	constructor() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	push(item) {
		const node = new Node(item);
		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}

		this.tail = node;
		this.length += 1;
	}

	pop() {
		const popItem = this.head;
		this.head = this.head.next;
		this.length -= 1;
		return popItem.item;
	}
}

const fs = require('fs');
const input = fs.readFileSync('./dev/stdin').toString().trim().split('\n');

const dx = [0, 0, 0, 0, -1, 1];
const dy = [0, 0, 1, -1, 0, 0];
const dz = [1, -1, 0, 0, 0, 0];

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
	const result = sol(L, R, C, building);
	answer.push(result);
}
console.log(answer.join('\n'));

function sol(L, R, C, building) {
	// 방문했던 곳 표시할 배열
	let visited = Array.from(Array(L), () => Array.from(Array(R), () => Array(L).fill(false)));

	// 상범이 위치와 목적지 찾기
	let s = [];
	let e = [];

	for (let k = 0; k < L; k++) {
		for (let i = 0; i < R; i++) {
			for (let j = 0; j < C; j++) {
				if (building[k][i][j] == 'S') {
					s = [k, i, j];
					visited[k][i][j] = true;
				} else if (building[k][i][j] == 'E') {
					e = [k, i, j];
				}
			}
		}
	}
	const q = new Queue();
	q.push([...s, 0]);
	while (q.length > 0) {
		const [z, x, y, t] = q.pop();
		if (z == e[0] && x == e[1] && y == e[2]) {
			return `Escaped in ${t} minute(s).`;
		}

		for (let k = 0; k < 6; k++) {
			const nz = z + dz[k];
			const nx = x + dx[k];
			const ny = y + dy[k];
			if (
				nz < 0 ||
				nz >= L ||
				nx < 0 ||
				nx >= R ||
				ny < 0 ||
				ny >= C ||
				visited[nz][nx][ny] ||
				building[nz][nx][ny] == '#'
			)
				continue;
			visited[nz][nx][ny] = true;
			q.push([nz, nx, ny, t + 1]);
		}
	}
	return 'Trapped!';
}