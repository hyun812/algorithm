function solution(n) {
    let answer = '';
    const nums = [4, 1, 2];

    while (n) {
        const result = n % 3;
        n = Math.floor((n - 1) / 3);
        
        answer = nums[result] + answer;
    }
    
    return answer;
}