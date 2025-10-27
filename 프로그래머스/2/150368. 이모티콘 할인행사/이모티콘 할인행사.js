function solution(users, emoticons) {
    let answer = [0, 0];
    
    const calc = (discount) => {
        let [count, sum] = [0, 0];
        
        users.forEach(([rate, price]) => {
            let sumPrice = 0;
            for (let i = 0; i < emoticons.length; i++) {
                if (rate > discount[i]) continue;
                sumPrice += (emoticons[i] / 100 * (100 - discount[i]));
            }
            
            if (sumPrice >= price) {
                count++
            } else sum += sumPrice;
        })

        return [count, sum];
    }
    
    const dfs = (index, discount) => {
        if (index === emoticons.length) {
            const [count, sum] = calc(discount);
            
            if (answer[0] < count) {
                answer[0] = count;
                answer[1] = sum;
            } else if (answer[0] === count) {
                answer[1] = Math.max(answer[1], sum);
            }

            return;
        }
        
        for (const d of [10, 20, 30, 40]) {
            dfs(index + 1, [...discount, d]);
        }
    }
    
    dfs(0, []);
          
          
    return answer;
}