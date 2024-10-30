const path = process.platform === 'linux' ? '/dev/stdin' : 'index.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n');

const [N, ATK] = input[0].split(' ').map(BigInt);

let left = BigInt(0);
let right = BigInt(0);

const rooms = [];
for (let i = 0; i < N; i++) {
  const [type, atk, hp] = input[i + 1].split(' ').map(BigInt);
  rooms.push([type, atk, hp]);
  if (type == 1) {
    right += (hp / ATK + BigInt(1)) * atk;
  }
}

const isDungeonClear = (maxHP) => {
  let curATK = ATK;
  let curHP = maxHP;

  for (const room of rooms) {
    const [type, atk, hp] = room;

    if (type == 1) {
      let man_hit = hp / curATK;
      if (hp % curATK != 0) {
        man_hit += BigInt(1);
      }

      const damage = (man_hit - BigInt(1)) * atk;
      curHP -= damage;

      if (curHP <= BigInt(0)) return false;
    } else if (type == 2) {
      curHP += hp;
      if (curHP > maxHP) curHP = maxHP;
      curATK += atk;
    }
  }
  return true;
};

let answer = right;
while (left <= right) {
  const mid = (left + right) / BigInt(2);

  if (isDungeonClear(mid)) {
    if (answer > mid) {
      answer = mid;
    }
    right = mid - BigInt(1);
  } else {
    left = mid + BigInt(1);
  }
}

console.log(String(answer));