function solution(n) {
    const dp = Array(n + 1).fill(0);
    const MOD = 1234567;
    
    dp[1] = 1;
    dp[2] = 2;
    
    for (let i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD;
    }
    
    return dp[n] % MOD;
}