function solution(begin, target, words) {  
    const isPossible = (cur, next) => {
        let cnt = 0;
        for (let i = 0; i < cur.length; i++) {
            if (cur[i] === next[i]) continue;
            cnt++;
        }
        
        return cnt === 1;
    }
    
    const bfs = () => {
        const queue = [[begin, 0]];
        const visited = new Set();
        visited.add(begin);    
        
        while (queue.length) {
            const [cur, count] = queue.shift();
            
            if (cur === target) {
                return count;
            }
            
            for (const word of words) {
                if (visited.has(word)) continue;
                if (!isPossible(cur, word)) continue;
                
                visited.add(word);
                queue.push([word, count + 1]);
            }
        }
        
        return 0;
    }
    
    return bfs();
}