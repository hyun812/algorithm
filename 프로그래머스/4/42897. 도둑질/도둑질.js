function solution(money) {
    var answer = 0;
    
    const dp1 = money.slice(0, money.length - 1);
    const dp2 = money.slice(1);

    const len = dp1.length;
    
    for(let i=2; i<money.length -1; i++){
        dp1[i] += Math.max(dp1[i-2], dp1[i-3] || 0);
        dp2[i] += Math.max(dp2[i-2], dp2[i-3] || 0);
    }
    
    return Math.max(dp1[len-1], dp1[len-2], dp2[len-1], dp2[len-2]);
}