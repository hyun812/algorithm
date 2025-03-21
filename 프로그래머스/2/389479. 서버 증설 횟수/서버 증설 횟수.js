function solution(players, m, k) {
    let answer = 0;
    
    const arr = Array(players.length).fill(0);
    
    for (let i = 0; i < players.length; i++) {
        const count = Math.floor(players[i] / m);
        
        if (count === 0) continue;
        if (arr[i] >= count) continue;
        const rest = count - arr[i];
        
        answer += rest;
        for (let j = i; j < Math.min(i + k, players.length); j++) {
            arr[j] += rest;
        }   
    }
    
    return answer;
}