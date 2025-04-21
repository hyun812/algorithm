function solution(s) {
    const results = s.split(' ').sort((a, b) => a - b);
    
    return `${results[0]} ${results[results.length - 1]}`;
}