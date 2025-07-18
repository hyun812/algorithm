function solution(msg) {
    const answer = [];
    const map = new Map();
    
    for (let i = 65; i < 65 + 26; i++) {
        map.set(String.fromCharCode(i), i - 64)
    }
    let count = 27;
    
    let input = "";
    for (let i = 0; i < msg.length; i++) {
        input += msg[i];
        
        if (!map.has(input)) {
            answer.push(map.get(input.slice(0, -1)));
            map.set(input, count++);
            input = msg[i];
        }
    }
    
    if (input) answer.push(map.get(input));
    return answer;
}