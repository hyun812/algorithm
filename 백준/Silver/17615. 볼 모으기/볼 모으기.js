const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];
const balls = input[1].slice(0, n + 1).split('');

/**
 * 1. 빨간색 공을 옮겨 빨간색 무리 + 파란색 무리로 모음
 * 2. 빨간색 공을 옮겨 파란색 무리 + 빨간색 무리로 모음
 * 3. 파란색 공을 옮겨 빨간색 무리 + 파란색 무리로 모음
 * 4. 파란색 공을 옮겨 파란색 무리 + 빨간색 무리로 모음
 */

const redCnt = balls.filter((ball) => ball === 'R').length;
const blueCnt = balls.filter((ball) => ball === 'B').length;

let answer = Infinity;

const targetLeftMoveCount = (target) => {
  let firstCount = 0;

  for (let i = 0; i < balls.length; i++) {
    if (balls[i] === target) break;
    firstCount++;
  }

  return (target === 'B' ? redCnt : blueCnt) - firstCount;
};

const targetRightMoveCount = (target) => {
  let firstCount = 0;

  for (let i = balls.length - 1; i >= 0; i--) {
    if (balls[i] === target) break;
    firstCount++;
  }

  return (target === 'B' ? redCnt : blueCnt) - firstCount;
};

answer = Math.min(answer, targetLeftMoveCount('R'), targetLeftMoveCount('B'));
answer = Math.min(answer, targetRightMoveCount('R'), targetRightMoveCount('B'));

console.log(answer);