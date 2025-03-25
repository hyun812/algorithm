function solution(info, n, m) {
  const INF = Infinity;

  // A의 누적 흔적을 인덱스로 사용하여, B의 최소 누적 흔적을 저장
  let dp = Array(n).fill(INF);
  dp[0] = 0; // A 흔적이 0일 때, B도 0으로 시작

  for (const [aTrace, bTrace] of info) {
    const nextDp = Array(n).fill(INF);

    for (let a = 0; a < n; a++) {
      const b = dp[a];
      if (b === INF) continue;

      // A가 훔치는 경우
      const newA = a + aTrace;
      const newB = b;
      if (newA < n) {
        nextDp[newA] = Math.min(nextDp[newA], newB);
      }

      // B가 훔치는 경우
      const newA2 = a;
      const newB2 = b + bTrace;
      if (newB2 < m) {
        nextDp[newA2] = Math.min(nextDp[newA2], newB2);
      }
    }

    dp = nextDp;
  }

  // A가 경찰에 안 잡히고, B도 안 잡히는 최소 A 흔적 찾기
  for (let a = 0; a < n; a++) {
    if (dp[a] < m) {
      return a;
    }
  }

  return -1; // 불가능한 경우
}