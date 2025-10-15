function solution(user_id, banned_id) {
    let answer = 0;
    
    const isPossible = (user, target) => {
        if (user.length !== target.length) return false;

        for (let i = 0; i < user.length; i++) {
            if (target[i] === '*') continue;
            if (user[i] !== target[i]) return false;
        }
        return true;
    }
    
    const set = new Set();
    const visited = Array(user_id.length).fill(0);
    const dfs = (index) => {
        if (index === banned_id.length) {
            const key = visited.join('');
            if (!set.has(key)) answer++;
            set.add(key);
            return;
        }
        
        const target = banned_id[index];
        for (let i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (isPossible(user_id[i], target)) {
                visited[i] = 1;
                dfs(index + 1);
                visited[i] = 0;
            }
        }
    }
    
    dfs(0);
    
    return answer;
}