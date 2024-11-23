function solution(cards) {
    const answer = [];
    
    const visited = Array(cards.length).fill(0);
    for (let i = 0; i < cards.length; i++) {
        let boxLength = 0;
        let target = cards[i];
        
        while (true) {
            if (visited[target]) break;
            
            visited[target] = 1;
            boxLength++;
            target = cards[target - 1];
        }
        
        boxLength && answer.push(boxLength);
    }
    
    answer.sort((a, b) => b - a);
    
    return answer.length > 1 ? answer[0] * answer[1] : 0;
}