function solution(sequence) {
    const n = sequence.length;
    let max1 = -Infinity, max2 = -Infinity;
    let dp1 = 0, dp2 = 0;

    for (let i = 0; i < n; i++) {
        const s1 = (i % 2 === 0 ? sequence[i] : -sequence[i]);
        const s2 = (i % 2 !== 0 ? sequence[i] : -sequence[i]);

        dp1 = Math.max(dp1 + s1, s1);
        dp2 = Math.max(dp2 + s2, s2);

        if (dp1 > max1) max1 = dp1;
        if (dp2 > max2) max2 = dp2;
    }
    
    return Math.max(max1, max2);
}
