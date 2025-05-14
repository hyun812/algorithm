function solution(k, tangerine) {
  let answer = 0;
  const map = {};

  tangerine.forEach((t) => (map[t] = (map[t] || 0) + 1));

  const tArr = Object.values(map).sort((a, b) => b - a);
    
  for (const t of tArr) {
    answer++;
    if (k > t) k -= t;
    else break;
  }

  return answer;
}