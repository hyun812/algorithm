const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const input = fs.readFileSync(filePath).toString().trim().split(/\s+/).map(Number);

const N = input[0];
const array = Array.from({ length: N }, (_, index) => index + 1);
const getPermutation = (arr, selectNum) => {
  const result = [];

  if (selectNum === 1) return arr.map((el) => [el]);

  arr.forEach((fixed, index, origin) => {
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    const permutation = getPermutation(rest, selectNum - 1);
    const attached = permutation.map((el) => [fixed, ...el]);

    result.push(...attached);
  });

  return result;
};

const answer = getPermutation(array, N);

answer.forEach((v) => {
  console.log(...v);
});