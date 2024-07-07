// n: 거슬러 줘야하는 금액
// money: 현재 보유하고 있는 돈의 종류
function solution(n, money) {
    let answer = 0;
    
    const dp = new Array(n+1).fill(0);
    dp[0] = 1;
    
    for(const value of money){
        for(let i=value; i<=n; i++){
            dp[i] = (dp[i] + dp[i-value]) % 1000000007;
        }    
    }
    
    return dp[n];
}