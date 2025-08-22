function solution(sticker) {
    const n = sticker.length;
    
    if(n === 1) return sticker[0];

    const dp1 = Array(n).fill(0); // 첫 스티커 뗀 경우
    const dp2 = Array(n).fill(0); // 첫 스티커 안뗀 경우
    
    dp1[0] = sticker[0];
    dp1[1] = sticker[0];
    for (let i = 2; i < n - 1; i ++) {
        dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
    }
    
    dp2[1] = sticker[1];
    for (let i = 2; i < n; i ++) {
        dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
    }
    
    const ans1 = Math.max(...dp1);
    const ans2 = Math.max(...dp2);
    return Math.max(ans1, ans2);
}