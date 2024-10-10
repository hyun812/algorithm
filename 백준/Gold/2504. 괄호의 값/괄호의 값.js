const fs = require('fs');
const filePath = process.platform === 'linux' ? './dev/stdin' : 'index.txt';
const [input] = fs.readFileSync(filePath).toString().trim().split('\n');

if (!isPossible(input)) {
  console.log(0);
  return;
}

const stack = [];
for (let i = 0; i < input.length; i++) {
  const char = input[i];
  const peek = stack[stack.length - 1];

  if (char === '(' || char === '[') stack.push(char);
  else {
    const reverse = char === ')' ? '(' : '[';
    const point = reverse === '(' ? 2 : 3;

    if (peek === reverse) {
      stack.pop();
      stack.push(point);
    } else {
      let temp = 0;
      while (true) {
        const pop = stack.pop();
        if (!isNaN(pop)) {
          temp += pop;
        } else if (pop === reverse) {
          stack.push(temp * point);
          break;
        }
      }
    }
  }
}

console.log(stack.reduce((acc, cur) => acc + cur, 0));

function isPossible(string) {
  const stack = [];

  for (const char of string) {
    const peek = stack[stack.length - 1];

    if (char === ')' && peek === '(') stack.pop();
    else if (char === ']' && peek === '[') stack.pop();
    else stack.push(char);
  }

  return stack.length ? false : true;
}
