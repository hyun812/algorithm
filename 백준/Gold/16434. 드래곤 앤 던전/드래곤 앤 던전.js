const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n").map(v => v.split(' ').map(Number))
const [N, _ATK] = input.shift();
const ATK = BigInt(_ATK)
let answer = Infinity;

const fight = (hp, atk) => {
  const MAX = hp;
  for (let i = 0; i < N; i++) {
    let [t, a, h] = input[i];
    a = BigInt(a)
    h = BigInt(h)
    switch (t) {
      case 1:
        let man_hit = h / atk
        if (man_hit * atk < h) {
          man_hit += BigInt(1)
        }
        const damage = (man_hit - BigInt(1)) * a;
        hp -= damage;
        break;
      case 2:
        hp += h;
        if (hp > MAX) hp = MAX;
        atk += a;
        break;
    }

    if (hp <= BigInt(0)) return false;
  }
  return true;
}



let min = BigInt(1);
let max = BigInt(0);

input.forEach(v => {
  let [t, a, h] = v;
  a = BigInt(a)
  h = BigInt(h)
  if (t == 1) {
    max += ((h / ATK) + BigInt(1)) * a
  }
})

while (min <= max) {
  let mid = (min + max) / BigInt(2);
  if (fight(mid, ATK)) {
    if (answer > mid) {
      answer = mid;
    }
    max = mid - BigInt(1);
  } else {
    min = mid + BigInt(1);
  }
}
console.log(String(answer))