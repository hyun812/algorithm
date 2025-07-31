function solution(triangle) {
    const N = triangle.length;
    
    for (let i = 1; i < N; i++) {
        for (let j = 0; j < triangle[i].length; j++) {
            const left = triangle[i - 1][j - 1] || 0;
            const right = triangle[i - 1][j] || 0;
            triangle[i][j] += Math.max(left, right);
        }
    }    
    
    return Math.max(...triangle[N - 1]);
}
