function solution(numbers) {
    
    const answer = numbers.map(String).sort((a, b) => {
        if (a + b > b + a) return -1;
        if (a + b < b + a) return 1;
        return 0;
    }).join('');

    return answer[0] === '0' ? '0' : answer;
}