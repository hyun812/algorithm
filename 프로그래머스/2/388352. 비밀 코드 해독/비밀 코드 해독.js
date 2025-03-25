function solution(n, q, ans) {
    let answer = 0;
    const nums = Array(n).fill(0).map((_, i) => i + 1);
    
    const checkQueries = (arr) => {
        for (let i = 0; i < q.length; i++) {
            const answer = ans[i];
            
            let count = 0;
            for (let j = 0; j < 5; j++) {
                if (arr.includes(q[i][j])) count++;
            }
            
            if (count !== answer) return false;
        }
        
        return true;
    }
    const getCombinations = (start = 0, arr = []) => {
        if (arr.length === 5) {
            if (checkQueries(arr)) answer++;
            return;
        }
        
        for (let i = start; i < n; i++) {
            arr.push(nums[i]);
            getCombinations(i + 1, arr);
            arr.pop();
        }
    }
    
    getCombinations();
    
    return answer;
}