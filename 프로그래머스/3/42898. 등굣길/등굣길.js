function solution(m, n, puddles) {
    const dp = Array.from({ length: n }, () => Array(m).fill(0));
    
    for (const [y, x] of puddles) {
        dp[x - 1][y - 1] = -1;        
    }
    
    dp[0][0] = 1;
    
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (i === 0 && j === 0) continue;
            if (dp[i][j] === -1) continue;
            const left = (j === 0 || dp[i][j - 1] === -1) ? 0 : dp[i][j - 1];
            const top = (i === 0 || dp[i - 1][j] === -1) ? 0 : dp[i - 1][j];
            dp[i][j] = (left + top) % 1000000007;
        }
    }
    
    return dp[n - 1][m - 1];
}