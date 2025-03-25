function solution(info, n, m) {
    const len = info.length;
    const dp = Array.from({ length: len + 1 }, () => Array(m).fill(Infinity));

    dp[0][0] = 0;
    
    for (let i = 0; i < len; i++) {
        const [aTrace, bTrace] = info[i];        
        
        for (let j = m - 1; j >= 0; j--) {
            if (dp[i][j] === Infinity) continue;
            
            
            // A가 훔치는 경우
            let newA = dp[i][j] + aTrace;
            let newB = j;
            if (newA < n) dp[i + 1][newB] = Math.min(dp[i + 1][newB], newA);

            // B가 훔치는 경우
            let newA2 = dp[i][j];
            let newB2 = j + bTrace;
            if (newB2 < m) dp[i + 1][newB2] = Math.min(dp[i + 1][newB2], newA2);
        }
    }

    const result = Math.min(...dp[len]);

    return result === Infinity ? -1 : result
}