function solution(n) {
    const dp = Array(n + 1).fill(Infinity);
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    
    for (let i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
    }
    
    return dp[n] % 1234567;
}