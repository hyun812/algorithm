const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [M, N, L] = input[0].split(' ').map(Number); // 사대의 수, 동물의 수, 사정 거리
const tower = input[1].split(' ').map(Number);
const animals = [];

for (let i = 2; i < N + 2; i++) {
  animals.push(input[i].split(' ').map(Number));
}

tower.sort((a, b) => a - b);

const binarySearch = (animal) => {
  let left = 0;
  let right = M - 1;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    let dis = Math.abs(tower[mid] - animal[0]) + animal[1];

    if (dis <= L) {
      // 저격할 수 있는 사대가 있다면
      return 1;
    }

    if (animal[0] < tower[mid]) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return 0;
};

let answer = 0;
for (const animal of animals) {
  // 동물을 기준으로 이분 탐색
  answer += binarySearch(animal);
}
console.log(answer);
