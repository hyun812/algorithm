function solution(n, words) {
    const answer = [0, 0];
    const set = new Set();
    
    let prev = words[0];
    set.add(prev);
    
    for (let i = 1; i < words.length; i++) {
        const word = words[i];
        
        if (set.has(word) || prev[prev.length - 1] !== word[0]) {
            answer[0] = i % n + 1;
            answer[1] = Math.floor(i / n) + 1;
            break;
        }
        
        set.add(word);
        prev = word;
    }
    
    return answer;
}