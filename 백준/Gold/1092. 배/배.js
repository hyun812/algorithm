const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = +input[0];
const crane = input[1].split(' ').map(i => +i);
const m = +input[2];
const box = input[3].split(' ').map(i => +i);

function solution(n, crane, m, box) {
	crane.sort((a, b) => b - a);
	box.sort((a, b) => b - a);
	let answer = 0;

	// 불가능 할 때 
	if (Math.max(...box) > crane[0]) return -1;

	while (box.length) {
		for (let i = 0; i < n; i += 1) {
			for (let j = 0; j < m; j += 1) {
				if (crane[i] >= box[j]) {
					box.splice(j, 1);
					break;
				}
			}
		}
		answer += 1;
	}

	return answer;
}

const answer = solution(n, crane, m, box);
console.log(answer);