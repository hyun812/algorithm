function solution(target) {
    const dp = Array(target + 1).fill(Infinity);
    const count = Array(target + 1).fill(0);

    dp[0] = 0;
    count[0] = 0;

    const scores = new Set();
    for (let i = 1; i <= 20; i++) {
        scores.add(i);
        scores.add(i * 2);
        scores.add(i * 3);
    }
    scores.add(50);
    

    for (let s of scores) {
        for (let i = s; i <= target; i++) {
            const newCount = count[i - s] + (s === 50 || s <= 20 ? 1 : 0);
            if (dp[i] > dp[i - s] + 1) {
                dp[i] = dp[i - s] + 1;
                count[i] = newCount;
            }else if (dp[i - s] + 1 === dp[i]) {
                count[i] = Math.max(count[i], newCount);
            }
        }
    }
    
    return [dp[target], count[target]];
}
