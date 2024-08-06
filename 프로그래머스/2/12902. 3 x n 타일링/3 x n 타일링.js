function solution(n) {
    const MOD = 1000000007;
    let dp = Array(n+1).fill(0);
    
    
    dp[2] = 3;
    dp[4] = 11;
    
    for(let i=6; i<=n; i+=2){
        let temp = dp[i-2] * 4 - (dp[i-4]);
        dp[i] = temp > 0 ? temp%MOD : temp + MOD;
    }
    
    return dp[n];
}